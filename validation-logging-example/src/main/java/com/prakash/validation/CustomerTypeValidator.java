package com.prakash.validation;

import static java.util.Arrays.*;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerTypeValidator implements ConstraintValidator<CustomerType, String> {

	static int count = 0;
	
	String test;
	
	public CustomerTypeValidator() {
		log.info("CustomerTypeValidator constructor - one time log of object/instance creation for first validation");
	} 
	
	@Override
	public void initialize(CustomerType customerType) {
		this.test = customerType.test();
	}
	
	@Override
	public boolean isValid(String customerType, ConstraintValidatorContext context) {
		
		log.info("CustomerTypeValidator class is running. count - " + (++count));
		List<String> types = asList("new", "existing");
		return types.contains(customerType.toLowerCase()) && this.test.equals("success");
	}

}
