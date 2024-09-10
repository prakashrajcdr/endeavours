package com.prakash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.prakash.entity.Employee;
import com.prakash.service.EmployeeService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching
public class RedisCacheApplication {
	
	@Autowired
	EmployeeService empService;

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@PostConstruct
	public void init() {
		try {
			empService.save(new Employee( "Prakash", "IT"));
			empService.save(new Employee( "Raj", "IT"));
			
//			empRepo.findAll();
			
		} catch (Exception e) {
			
		}
	}
}
