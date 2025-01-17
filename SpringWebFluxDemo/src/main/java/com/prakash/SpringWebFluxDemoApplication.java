package com.prakash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringWebFluxDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxDemoApplication.class, args);
		log.info("SpringWebFluxDemoApplication working... ");
	}

}
