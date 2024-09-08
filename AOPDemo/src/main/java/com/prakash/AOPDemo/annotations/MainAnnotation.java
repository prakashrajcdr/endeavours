package com.prakash.AOPDemo.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainAnnotation {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		Bike bike = new Bike("AK");
		
		//Field
		for(Field field : Bike.class.getDeclaredFields()) {
			if(field.isAnnotationPresent(Important.class)) 
				System.out.println("Bike model - " + field.get(bike));
		}
		
		//Method
		for(Method method : Bike.class.getDeclaredMethods()) {
			if(method.isAnnotationPresent(Important.class))
				method.invoke(bike);
		}


	}

}
