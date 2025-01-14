package com.prakash;

import org.junit.jupiter.api.Test;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoTest {

	@Test
	public void monoTest() {
		Mono<?> monoString = Mono.just("Test")
				.then(Mono.error(new RuntimeException("Exception by mono")))
				.log();
		
		System.out.println("thread - " + Thread.currentThread().getName());
		Disposable dis = monoString.subscribe(sub->{
			System.out.println(sub + " - subscripe - " + Thread.currentThread().getName());

		});
//		dis.dispose();
	}
	
}
