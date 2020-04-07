package com.example.socialratingcalculator.application;

import com.example.socialratingcalculator.domain.model.User;
import com.example.socialratingcalculator.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	static final class UserNotFoundException extends RuntimeException {
		private final String firstName;

		UserNotFoundException(String firstName) {
			super();
			this.firstName = firstName;
		}

		@Override
		public String getMessage() {
			return "User with firstName " + firstName + " not found";
		}
	}

	static final class UserAlreadyExistException extends RuntimeException {
		private final String firstName;

		UserAlreadyExistException(String firstName) {
			super();
			this.firstName = firstName;
		}

		@Override
		public String getMessage() {
			return "User with firstName " + firstName + " already exist";
		}
	}

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUserByName(String firstName) {
		return userRepository.findByFirstName(firstName)
				.stream().findFirst()
				.orElseThrow(() -> new UserNotFoundException(firstName));
	}

	public User createUser(User user) {
		if (userRepository.findByFirstName(user.getFirstName())
				.stream().findFirst().isPresent()) {
			throw new UserAlreadyExistException(user.getFirstName());
		}

		return userRepository.save(user);
	}
}
