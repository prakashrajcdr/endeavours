package com.prakash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.prakash.entity.Employee;
import com.prakash.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Caching(put = {
			@CachePut(value = "employee", key="#employee.id")			
	}, evict = {
			@CacheEvict(value = "employee", allEntries = true)
	})
	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	@Cacheable(value = "employee")
	public List<Employee> getAll(){
		return employeeRepo.findAll();
	}
	
	@Cacheable(value = "employee", key = "#id")
	public Employee getById(Integer id) {
		return employeeRepo.findById(id).orElseThrow();
	}
	
	@Caching(evict = {
			@CacheEvict(value="employee", allEntries = true), // it will clear all the cache
			@CacheEvict(value = "employee", key="#id") // since above it is not required
	})
	public void deleteById(Integer id) {
		employeeRepo.deleteById(id);
	}
}
