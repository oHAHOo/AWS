package org.zerock.aws.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.aws.dto.CreateMemberRequest;
import org.zerock.aws.dto.CreateMemberResponse;
import org.zerock.aws.dto.GetMemberResponse;
import org.zerock.aws.entity.Member;
import org.zerock.aws.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	@Transactional
	public CreateMemberResponse createMember(CreateMemberRequest createMemberRequest) {
		Member member = new Member(
			createMemberRequest.getName(),
			createMemberRequest.getAge(),
			createMemberRequest.getMbti());
		Member savedMember = memberRepository.save(member);

		return CreateMemberResponse.from(savedMember);
	}

	@Transactional(readOnly = true)
	public GetMemberResponse getMember(Long id) {
		Member member  = memberRepository.findById(id).orElseThrow(() -> new IllegalStateException("not found member"));

		return GetMemberResponse.from(member);
	}
}
