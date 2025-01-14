package com.prakash.controller;

import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.prakash.dto.Customer;
import com.prakash.service.WebFluxService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("customer")
public class SpringWebFluxController {
	
	@Autowired
	WebFluxService webFluxService;

	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getCustomer(@RequestHeader("host") String header){
//		InetSocketAddress isa = header.host();
//		log.info("header InetSocketAddress - " + isa);
//		log.info("header getHostName - " + isa.getHostName());
//		log.info("header getPort - " + isa.getPort());
		log.info("header host - " + header);
		return webFluxService.getAllCustomers();
	}
	@GetMapping
	public String test(){
		return "Api working...";
	}
}
