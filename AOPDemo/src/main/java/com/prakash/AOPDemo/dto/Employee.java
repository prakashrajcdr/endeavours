package com.prakash.AOPDemo.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Employee {

//	@JsonProperty(required = true) // it will work jackson 1.x version only otherwise go with constructor args
	private Integer id;
	private String name;
	private String department;
	
	@JsonCreator
    public Employee(@JsonProperty(value = "id") Integer id,
                    @JsonProperty(value = "name", required = true) String name,
                    @JsonProperty("department") String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}
