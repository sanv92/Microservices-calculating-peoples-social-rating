package com.example.socialratingcalculator.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@NoArgsConstructor
@Getter
@ToString
@RedisHash("users")
public class User {

	@Id
	private Long id;

	@Indexed
	private String firstName;

	@Indexed
	private String lastName;

	private int age;

	private int score;

	public User(String firstName, String lastName, int age, int score) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.score = score;
	}
}