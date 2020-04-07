package com.example.datacollector.infrastructure.messaging;

import com.example.schemaregistry.UserCreatedEvent;
import com.example.datacollector.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserSenderService {

	private final KafkaTemplate<String, GenericRecord> kafkaTemplate;

	@Value(value = "${kafka.topic-user}")
	private String topic;

	@Value(value = "${social.base-score-rating}")
	private int baseScoreRating;

	@Autowired
	public UserSenderService(KafkaTemplate<String, GenericRecord> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sender(User user) {
		 kafkaTemplate.send(topic, createUserCreatedEvent(user));
	}

	private UserCreatedEvent createUserCreatedEvent(User user) {
		return UserCreatedEvent.newBuilder()
				.setFirstName(user.getFirstName())
				.setLastName(user.getLastName())
				.setAge(user.getAge())
				.setBaseScoreRating(baseScoreRating)
				.build();
	}
}
