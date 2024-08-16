package com.prakash.service;

import java.util.concurrent.CompletableFuture;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.prakash.dto.Customer;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Service
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	NewTopic newTopic;
	
	public void sendMessageToTopic(String message) {
		try {
			CompletableFuture<SendResult<String, Object>> completableFuture 
				= kafkaTemplate.send(newTopic.name(), message);
			log.info("inside sendMessageToTopic - thread is {}", Thread.currentThread().getName());
			completableFuture.whenComplete((obj, exception) -> {
				log.info("producer record data {} ---", obj.getProducerRecord().value());
			});
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void sendMessageToTopic(Customer customer) {
		try {
			kafkaTemplate.send("prakash-spring-topic-2", customer);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
