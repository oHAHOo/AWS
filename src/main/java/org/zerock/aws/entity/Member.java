package org.zerock.aws.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table (name = "members")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;
	@Column
	private int age;
	@Column
	private String mbti;
	@Column
	private String profileImageUrl;

	public Member(String name, int age, String mbti) {
		this.name = name;
		this.age = age;
		this.mbti = mbti;
	}

	public void updateProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
}
