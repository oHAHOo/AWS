package org.zerock.aws.dto;

import lombok.Getter;

@Getter
public class CreateMemberRequest {
	private String name;
	private int age;
	private String mbti;

	public CreateMemberRequest(String name, int age, String mbti) {
		this.name = name;
		this.age = age;
		this.mbti = mbti;
	}
}
