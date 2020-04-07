package com.example.datacollector.configs.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {

	@Value(value = "${kafka.topic-partitions-num}")
	private short partitionsNum;

	@Value(value = "${kafka.topic-replication-factor}")
	private short replicationFactor;

	@Value(value = "${kafka.topic-user}")
	private String messageTopicUser;

	@Bean
	public NewTopic topicUser() {
		return new NewTopic(messageTopicUser, partitionsNum, replicationFactor);
	}
}
