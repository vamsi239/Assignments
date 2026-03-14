package com.lpu.employeeapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class EmployeeDTO {

 
    @NotBlank(message = "Employee name cannot be empty")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Positive(message = "Salary must be greater than 0")
    private double salary;
 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public EmployeeDTO() {
		super();
	}

    // getters & setters
}