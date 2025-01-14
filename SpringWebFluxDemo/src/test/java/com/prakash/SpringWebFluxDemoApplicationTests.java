package com.prakash;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(Suite.class)
@SuiteClasses({
	MonoTest.class,
	FluxTest.class
})
class SpringWebFluxDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
