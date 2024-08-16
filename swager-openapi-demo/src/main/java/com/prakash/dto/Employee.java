package com.prakash.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class Employee {

	@Schema(description = "employee id", example = "101", requiredMode = RequiredMode.REQUIRED)
	private Integer id;
	private String name;
	private String code;
	private String designation;
	private String department;
	
}
