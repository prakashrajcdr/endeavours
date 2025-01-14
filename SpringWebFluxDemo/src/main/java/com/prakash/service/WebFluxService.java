package com.prakash.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.prakash.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class WebFluxService {

	public Flux<Customer> getAllCustomers(){
		return Flux.range(1, 20)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i -> System.out.println("Flux processing - "+ i))
				.map(i -> new Customer(i, "Customer "+ i, Thread.currentThread().getName()));
	}
}
