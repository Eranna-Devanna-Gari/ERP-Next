package com.zerozilla.erpnext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zerozilla.erpnext.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("From Employee where code = :code")
	Employee getEmployeeByCode(String code);

}
