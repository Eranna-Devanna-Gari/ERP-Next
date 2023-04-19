package com.zerozilla.erpnext.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private @Getter @Setter Long id;
	
	@Column(name = "emp_name")
	private @Getter @Setter String name;
	
	@Column(name = "emp_code")
	private @Getter @Setter String code;
	
	@Column(name = "emp_designation")
	private @Getter @Setter String designation;
	
	@Column(name = "emp_type")
	private @Getter @Setter String employeeType;
	
	@Column(name = "emp_email")
	private @Getter @Setter String email;
	
	@Column(name = "emp_mobile_number")
	private @Getter @Setter String mobileNumber;
}
