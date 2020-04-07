package com.example.datacollector.configs;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(SocialProperties.class)
@PropertySource("classpath:social.properties")
public class SocialAutoConfiguration {

}
