package com.example.datacollector.interfaces.web.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

	private Long id;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private LocalDateTime birthdayDateTime;
}
