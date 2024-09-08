package com.prakash.AOPDemo.annotations;

public class Bike {

	@Important
	String model;
	
	int number;
	
	public Bike(String model) {
		this.model = model;
	}
	
	@Important
	public void run() {
		System.out.println("Bike is running...");
	}
}
