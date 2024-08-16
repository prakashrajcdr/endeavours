package com.prakash.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.dto.Customer;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ValidationController {

//	private static Logger log = LoggerFactory.getLogger(ValidationController.class);
	@PostMapping
	public ResponseEntity<?> post(@Valid @RequestBody Customer customer){
		log.info("customer -> {}", customer);
		return ResponseEntity.ok("Posted..");
	}
}
