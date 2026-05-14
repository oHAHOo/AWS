package org.zerock.aws.dto;

import org.zerock.aws.entity.Member;

import lombok.Getter;

@Getter
public class CreateMemberResponse {

	private final Long id;
	private final String name;
	private final int age;
	private final String mbti;

	private CreateMemberResponse(Long id, String name, int age, String mbti) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.mbti = mbti;
	}

	public static CreateMemberResponse from(Member member) {
		return new CreateMemberResponse(member.getId(), member.getName(), member.getAge(), member.getMbti());
	}
}
