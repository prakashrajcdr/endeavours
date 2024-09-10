package com.prakash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.entity.Employee;
import com.prakash.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.save(employee));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return ResponseEntity.ok(employeeService.getAll());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(employeeService.getById(id));
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id)  {
		employeeService.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
}
