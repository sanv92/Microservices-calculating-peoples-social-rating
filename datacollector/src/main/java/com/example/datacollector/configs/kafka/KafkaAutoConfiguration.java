package com.example.datacollector.configs.kafka;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
@PropertySource("classpath:kafka.properties")
public class KafkaAutoConfiguration {

}
