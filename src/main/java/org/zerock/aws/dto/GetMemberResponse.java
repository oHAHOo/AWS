package org.zerock.aws.dto;

import org.zerock.aws.entity.Member;

import lombok.Getter;

@Getter
public class GetMemberResponse {

	private final Long id;
	private final String name;
	private final int age;
	private final String mbti;

	private GetMemberResponse(Long id, String name, int age, String mbti) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.mbti = mbti;
	}

	public static GetMemberResponse from(Member member) {
		return new GetMemberResponse(member.getId(), member.getName(), member.getAge(), member.getMbti());
	}
}
