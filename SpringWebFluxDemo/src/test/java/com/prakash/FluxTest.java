package com.prakash;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class FluxTest {
	@Test
	public void fluxTest() {
		
		Flux<?> fluxString = Flux.just("A", "B", "C", "D")
				.concatWithValues("E")
				.concatWith(Flux.error(new RuntimeException("Exception by flux")))
				.log();
		
		fluxString.subscribe(data -> {
			System.out.println("flux String- " + data);
		});
	}

}
