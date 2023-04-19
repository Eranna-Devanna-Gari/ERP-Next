package com.zerozilla.erpnext.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerozilla.erpnext.model.Employee;
import com.zerozilla.erpnext.repository.EmployeeRepository;
import com.zerozilla.erpnext.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		
		Employee add = employeeRepository.save(employee);
		return add;
	}
	
	@Override
	public List<Employee> employeesList() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}
	
	@Override
	public Optional<Employee> getEmployeeDetails(Long id) {
		Optional<Employee> empById = this.employeeRepository.findById(id);
		return empById;
	}
	
	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}
	
	@Override
	public Employee updateEmployeeDetails(Employee employee, Long id) {
		Employee emp1 = employeeRepository.findById(id).orElse(employee);
		emp1.setName(employee.getName());
		emp1.setCode(employee.getCode());
		emp1.setDesignation(employee.getDesignation());
		emp1.setEmployeeType(employee.getEmployeeType());
		emp1.setEmail(employee.getEmail());
		emp1.setMobileNumber(employee.getMobileNumber());
		
		Employee employee2 = employeeRepository.save(emp1);
		return employee2;
	}
	
	@Override
	public Employee getEmployeeByCode(String code) {
		Employee emp = employeeRepository.getEmployeeByCode(code);
		return emp;
	}

}
