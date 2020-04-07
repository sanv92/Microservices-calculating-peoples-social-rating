package com.example.socialratingcalculator.infrastructure.messaging;

import com.example.schemaregistry.UserCreatedEvent;
import com.example.socialratingcalculator.application.UserService;
import com.example.socialratingcalculator.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceEventConsumer {

	private UserService userService;

	@Autowired
	public UserServiceEventConsumer(UserService userService) {
		this.userService = userService;
	}

	@KafkaListener(topics = "${kafka.topic-user}", groupId = "${kafka.consumer-group-id}")
	public void listen(@Payload ConsumerRecord<String, UserCreatedEvent> record) {
		final var userCreatedEvent = record.value();

		log.info("FirstName: {}, LastName: {}, Age: {}, SocialRatingScore: {}",
				userCreatedEvent.getFirstName(),
				userCreatedEvent.getLastName(),
				userCreatedEvent.getAge(),
				calculateSocialRatingScore(userCreatedEvent.getBaseScoreRating(), userCreatedEvent.getAge())
		);

		userService.createUser(
				new User(
						userCreatedEvent.getFirstName(),
						userCreatedEvent.getLastName(),
						userCreatedEvent.getAge(),
						calculateSocialRatingScore(userCreatedEvent.getBaseScoreRating(), userCreatedEvent.getAge())
				)
		);
	}

	private int calculateSocialRatingScore(int baseSeed, int age) {
		return baseSeed * age;
	}
}
