package com.example.datacollector.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.Period;

@NoArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(
			name = "user_id_generator",
			sequenceName = "user_id_seq",
			allocationSize = 1
	)
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	private Long id;

	@NotNull
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotNull
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@NotNull
	@Column(name = "birthday_date", nullable = false)
	private LocalDateTime birthdayDateTime;

	public User(String firstName, String lastName, LocalDateTime birthdayDateTime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdayDateTime = birthdayDateTime;
	}

	public int getAge() {
		return Period.between(birthdayDateTime.toLocalDate(), LocalDateTime.now().toLocalDate())
				.getYears();
	}
}
