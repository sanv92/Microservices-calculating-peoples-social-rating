package com.example.socialratingcalculator.configs.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
		prefix = "kafka"
)
public class KafkaProperties {

	private short topicPartitionsNum;

	private short topicReplicationFactor;

	private String topicUser;

	private String consumerGroupId;

	public short getTopicPartitionsNum() {
		return topicPartitionsNum;
	}

	public void setTopicPartitionsNum(short topicPartitionsNum) {
		this.topicPartitionsNum = topicPartitionsNum;
	}

	public short getTopicReplicationFactor() {
		return topicReplicationFactor;
	}

	public void setTopicReplicationFactor(short topicReplicationFactor) {
		this.topicReplicationFactor = topicReplicationFactor;
	}

	public String getTopicUser() {
		return topicUser;
	}

	public void setTopicUser(String topicUser) {
		this.topicUser = topicUser;
	}

	public String getConsumerGroupId() {
		return consumerGroupId;
	}

	public void setConsumerGroupId(String consumerGroupId) {
		this.consumerGroupId = consumerGroupId;
	}
}
