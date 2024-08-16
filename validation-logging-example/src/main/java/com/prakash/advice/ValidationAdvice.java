package com.prakash.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> exceptionHandler(MethodArgumentNotValidException ex){
		Map<String, Object> exResult = new HashMap<>();
		
		ex.getFieldErrors().forEach(x-> {
			exResult.put(x.getField(), x.getDefaultMessage());
		});
//		ex.getAllErrors().forEach(x -> {
//			exResult.put("", x.getDefaultMessage());
//		});
		return new ResponseEntity(exResult, HttpStatus.BAD_REQUEST);
	}
}
