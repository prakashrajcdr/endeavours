package com.prakash.AOPDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.AOPDemo.annotations.Important;
import com.prakash.AOPDemo.dto.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {
	
	static List<Employee> emps = new ArrayList<>();

    @GetMapping(path = "/get/{index}")
    public Employee get(@PathVariable("index") Integer index){
        log.info("Get(index) method invoked..");
        return emps.get(index);
    }
    
    @GetMapping(path = "/get")
    @Important
    public List<Employee> get(){
        log.info("Get(All) method invoked..Thread- " + Thread.currentThread().getName());
        return emps;
    }
    
    @PostMapping("/post")
    public String post(@RequestBody Employee emp) {
        log.info("Post method invoked - " + emp);
        emps.add(emp);
    	return "posted successfully";
    }
    
    @PutMapping(path = "/clear")
    public String clear(){
        log.info("Put method invoked..");
        int size = emps.size();
        emps.clear();
        return size + " Cleared";
    }

}
