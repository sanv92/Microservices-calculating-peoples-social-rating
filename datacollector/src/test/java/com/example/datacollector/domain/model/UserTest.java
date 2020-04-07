package com.example.datacollector.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

	@Test
	@DisplayName("Calculate user age")
	void shouldCalculateCorrectAgeNumber() {
		final var user = new User("Test1", "Test2", LocalDateTime.now().minusYears(5));
		assertEquals(5, user.getAge());
	}
}