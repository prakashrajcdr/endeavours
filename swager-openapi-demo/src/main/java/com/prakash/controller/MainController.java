package com.prakash.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.dto.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee-api")
@Tag(name = "Employee", description = "Employee Tag description")
public class MainController {

	@Operation(summary = "getAllEmployee summary", 
			description = "getAllEmployee description",
			deprecated = false, hidden = false, tags = {"Employee"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", 
						description = "200 Successs Response", 
						content = {@Content(mediaType = "application/json", 
											array = @ArraySchema(schema = @Schema(implementation = Employee.class)))},
						headers = {@Header(name = "test-header", example = "example-header-description", schema = @Schema(type = "String")),
									@Header(name = "test-header2", example = "example-header-description2")
						}),
			@ApiResponse(responseCode = "400", description = "Bad Request")
	})
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list = null;
		return ResponseEntity.ok(list);
	}

	@Operation(summary = "getEmployeeById", description = "pass employee id")
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@Parameter(
			description = "pass employee id", in = ParameterIn.PATH) 
		@PathVariable(value = "id") Integer id){
		
		Employee emp = null;
		return ResponseEntity.ok(emp);
	}

	@Operation(summary = "addEmployee", description = "pass employee parameters")
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(
					description = "pass employee object",
					content = {@Content(schema = @Schema(implementation = Employee.class))})
			@RequestBody Employee emp){
		return ResponseEntity.ok(emp);
	}

	
}
