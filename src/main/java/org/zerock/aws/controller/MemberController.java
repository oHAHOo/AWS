package org.zerock.aws.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.aws.dto.CreateMemberRequest;
import org.zerock.aws.dto.CreateMemberResponse;
import org.zerock.aws.dto.GetMemberResponse;
import org.zerock.aws.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {
	private final MemberService memberService;

	@PostMapping
	public ResponseEntity<CreateMemberResponse> createMember(@RequestBody CreateMemberRequest createMemberRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(memberService.createMember(createMemberRequest));
	}

	@GetMapping("{id}")
	public ResponseEntity<GetMemberResponse> getMember(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(memberService.getMember(id));
	}
}
