package com.lpu.employeeapp.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CompanyDTO {

 
    @NotBlank(message = "Company name cannot be empty")
    @Size(min = 2, max = 50, message = "Company name must be between 2 and 50 characters")
    private String name;

    @Valid
    private List<EmployeeDTO> employeelist;
    
    
    
    public CompanyDTO() {
    	super();
    }

 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeDTO> getEmployeelist() {
		return employeelist;
	}

	public void setEmployeelist(List<EmployeeDTO> employeelist) {
		this.employeelist = employeelist;
	}

    // getters & setters
}