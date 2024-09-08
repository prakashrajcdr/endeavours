package com.prakash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prakash.entity.Employee;
import com.prakash.repository.EmployeeRepo;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class RedisCacheApplication {
	
	@Autowired
	EmployeeRepo empRepo;

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@PostConstruct
	public void init() {
		try {
			empRepo.save(new Employee( "Prakash", "IT"));
			empRepo.save(new Employee( "Raj", "IT"));
			
		} catch (Exception e) {
			
		}
	}
}
