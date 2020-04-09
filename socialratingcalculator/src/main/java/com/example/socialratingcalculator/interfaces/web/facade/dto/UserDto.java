package com.example.socialratingcalculator.interfaces.web.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

	private Long id;

	private String firstName;

	private String lastName;

	private int age;

	private int score;
}
