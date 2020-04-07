package com.example.datacollector.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

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
