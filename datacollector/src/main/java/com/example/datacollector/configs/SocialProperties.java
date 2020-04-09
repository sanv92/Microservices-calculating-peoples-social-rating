package com.example.datacollector.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(SocialProperties.class)
@PropertySource("classpath:social.properties")
@ConfigurationProperties(
		prefix = "social"
)
public class SocialProperties {

	private Integer baseScoreRating;

	public Integer getBaseScoreRating() {
		return baseScoreRating;
	}

	public void setBaseScoreRating(Integer baseScoreRating) {
		this.baseScoreRating = baseScoreRating;
	}
}
