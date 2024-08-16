package com.prakash.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.prakash.dto.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
//@EnableKafka //it will auto configure by spring boo auto configuration even if we not mentioned
@Slf4j
public class KafkaConsumerService {
		
	@KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.group-id}")
	public void listenKafkaMessage(ConsumerRecord<String, Object> cr) {
		log.info("Consumer received message which is -> {}", cr.value());
	}
	
	@KafkaListener(topics = "prakash-spring-topic-2", groupId = "${kafka.group-id}'")
	public void listenKafkaMessageCustomer(ConsumerRecord<String, Customer> cr) {
		try {
			log.info("Customer Consumer message - name is {}", cr.value().getName());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
