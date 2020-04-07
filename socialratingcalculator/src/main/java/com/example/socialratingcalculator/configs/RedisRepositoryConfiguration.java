package com.example.socialratingcalculator.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisRepositoryConfiguration {

	@Value(value = "${spring.redis.host}")
	private String redisHostname;

	@Value(value = "${spring.redis.port}")
	private int redisPort;

	@Value(value = "${spring.redis.database}")
	private int databaseNumber;

	@Bean
	public RedisConnectionFactory connectionFactory() {
		final var redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName(redisHostname);
		redisStandaloneConfiguration.setPort(redisPort);
		redisStandaloneConfiguration.setDatabase(databaseNumber);
		redisStandaloneConfiguration.setPassword(RedisPassword.none());
		return new LettuceConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
}
