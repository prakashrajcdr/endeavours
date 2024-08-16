package com.prakash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prakash.dto.Customer;
import com.prakash.service.KafkaProducerService;

@RestController
public class ProducerController {
	
	@Autowired
	KafkaProducerService kafkaService;

	@GetMapping("publishMessage/{msg}")
	public ResponseEntity<?> publishMessage(@PathVariable("msg") String messge){
		kafkaService.sendMessageToTopic(messge);
		return ResponseEntity.ok(messge + "- Published...");
	}
	
	@PostMapping("publishMesssage")
	public ResponseEntity<?> publishCustomerMessage(@RequestBody Customer cusomer){
		kafkaService.sendMessageToTopic(cusomer);
		return ResponseEntity.ok("Customer - Published...");
	}
}
