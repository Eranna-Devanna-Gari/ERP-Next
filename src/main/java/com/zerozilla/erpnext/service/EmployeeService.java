package com.zerozilla.erpnext.service;

import java.util.List;
import java.util.Optional;

import com.zerozilla.erpnext.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	List<Employee> employeesList();

	Optional<Employee> getEmployeeDetails(Long id);

	void deleteEmployee(Long id);

	Employee updateEmployeeDetails(Employee employee, Long id);

	Employee getEmployeeByCode(String code);

}
