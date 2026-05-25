package org.zerock.aws.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.aws.dto.FileDownloadUrlResponse;
import org.zerock.aws.dto.FileUploadResponse;
import org.zerock.aws.service.S3Service;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class FileController {

	private final S3Service s3Service;

	@PostMapping("/{id}/profile-image")
	public ResponseEntity<FileUploadResponse> upload(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
		String key = s3Service.upload(id, file);
		return ResponseEntity.ok(new FileUploadResponse(key));
	}

	@GetMapping("/{id}/profile-image")
	public ResponseEntity<FileDownloadUrlResponse> getDownloadUrl(@PathVariable Long id, @RequestParam String key) {
		String url = s3Service.getDownloadUrl(id, key);
		return ResponseEntity.ok(new FileDownloadUrlResponse(url));
	}
}
