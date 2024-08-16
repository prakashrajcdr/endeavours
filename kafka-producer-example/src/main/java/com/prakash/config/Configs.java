package com.prakash.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.prakash.service.KafkaProducerService;

import lombok.extern.slf4j.Slf4j;

@Configuration
public class Configs {

	@Value("${kafka.topic}")
	public String topic;
	
	@Bean
	public NewTopic createTopic() {
		return new NewTopic(topic, 10, (short)1);
	}
}
