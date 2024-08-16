package com.prakash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaExampleApplication {

	public static void main(String[] args) {
		System.out.println("Starting...");
		SpringApplication.run(KafkaExampleApplication.class, args);
	}

}
