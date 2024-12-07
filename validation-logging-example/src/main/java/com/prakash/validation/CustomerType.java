package com.prakash.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CustomerTypeValidator.class)
public @interface CustomerType {
	
	String message() default "{jakarta.validation.constraints.NotNull.message}";
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
	String test() default "success";


}
