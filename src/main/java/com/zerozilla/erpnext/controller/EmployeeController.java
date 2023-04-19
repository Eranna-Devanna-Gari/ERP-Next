package com.zerozilla.erpnext.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerozilla.erpnext.apiresponse.ApiResponse;
import com.zerozilla.erpnext.model.Employee;
import com.zerozilla.erpnext.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		try {
			Employee emp = employeeService.addEmployee(employee);
			System.out.println(emp);
			return ApiResponse.generateResponse(HttpStatus.CREATED, "Employee successfully added", emp);
		} catch (Exception e) {
			return ApiResponse.generateResponse(HttpStatus.MULTI_STATUS, e.getMessage(), null);
		}
		
	}
	
	@GetMapping("/getEmployeesList")
	public ResponseEntity<Object> getEmployeeList() {
		try {
			List<Employee> employees= employeeService.employeesList();
			return ApiResponse.generateResponse(HttpStatus.OK, "All Employees List", employees);
		} catch (Exception e) {
			return ApiResponse.generateResponse(HttpStatus.MULTI_STATUS, e.getMessage(), null);
		}
	}
	
	@GetMapping("/getEmployeeDetails/{id}")
	public ResponseEntity<Object> getEmployeeDetails(@PathVariable Long id) {
		try {
			Optional<Employee> emp = this.employeeService.getEmployeeDetails(id);
			return ApiResponse.generateResponse(HttpStatus.OK, "Individual Employee Details", emp);
		} catch (Exception e) {
			return ApiResponse.generateResponse(HttpStatus.MULTI_STATUS, e.getMessage(), null);
		}
	}
	
	@DeleteMapping("/deleteEmloyee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
		try {
			 employeeService.deleteEmployee(id);
			 return ApiResponse.generateResponse(HttpStatus.OK, "Employee deleted successfully", id);
		} catch (Exception e) {
			return ApiResponse.generateResponse(HttpStatus.MULTI_STATUS, e.getMessage(), null);
		}
	}
	
	@PutMapping("/updateEmployeeDetails/{id}")
	public ResponseEntity<Object> updateEmployeeDetails(@RequestBody Employee employee, @PathVariable Long id) {
		try {
			Employee updatedEmployeeDetails = employeeService.updateEmployeeDetails(employee,id);
			return ApiResponse.generateResponse(HttpStatus.OK, "Employee DEtails updated successfully", updatedEmployeeDetails);
		} catch (Exception e) {
			return ApiResponse.generateResponse(HttpStatus.MULTI_STATUS, e.getMessage(), null);
		}
	}
	
	public ResponseEntity<Object> getEmployeeByCode(@PathVariable String code) {
		try {
			Employee emp = employeeService.getEmployeeByCode(code);
			return ApiResponse.generateResponse(HttpStatus.OK, "Retrieve the Employee Details By Code", emp);
		} catch (Exception e) {
			return ApiResponse.generateResponse(HttpStatus.MULTI_STATUS, e.getMessage(), null);
		}
	}
	
	public void hello() {
		System.out.println("Hello");
	}
}
