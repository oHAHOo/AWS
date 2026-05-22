package org.zerock.aws.service;

import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.aws.entity.Member;
import org.zerock.aws.repository.MemberRepository;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

	private static final Duration PRESIGNED_URL_EXPIRATION = Duration.ofDays(7);

	private final S3Template s3Template;
	private final MemberRepository memberRepository;

	@Value("${spring.cloud.aws.s3.bucket}")
	private String bucket;

	public String upload(Long id,MultipartFile file) {
		try {
			String key = "uploads/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
			s3Template.upload(bucket, key, file.getInputStream());

			Member member = memberRepository.findById(id).orElseThrow(()->new IllegalStateException("Member Not Found"));
			member.updateProfileImageUrl(key);
			memberRepository.save(member);

			return key;
		} catch (IOException e) {
			throw new RuntimeException("파일 업로드 실패", e);
		}
	}

	public URL getDownloadUrl(Long id, String key) {
		return s3Template.createSignedGetURL(bucket, key, PRESIGNED_URL_EXPIRATION);
	}
}
