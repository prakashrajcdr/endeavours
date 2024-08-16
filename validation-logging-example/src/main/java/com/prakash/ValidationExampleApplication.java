package com.prakash;

import org.jboss.logging.MDC;
import org.slf4j.event.Level;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
//@PropertySource("classpath:myapplication.properties")
@Slf4j
public class ValidationExampleApplication {

	public static void main(String[] args) {
		MDC.put("mdc_key", "mdc-value");
//		log.info("info level logging.");
		SpringApplication.run(ValidationExampleApplication.class, args);
		log.info("isDebugEnabled logging.{} --", log.isDebugEnabled());
		log.info("isEnabledForLevel(Level.INFO logging.{} --", log.isEnabledForLevel(Level.INFO));
		log.trace("trace level logging.");
		log.debug("debug level logging.");
		log.info("info level logging.");
		log.warn("warn level logging.");
		log.error("error level logging.");
	}

}
