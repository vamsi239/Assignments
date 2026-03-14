package com.lpu.employeeapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.employeeapp.Entity.Employee;
import com.lpu.employeeapp.Repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo emprepo;
	
	
	
	public Employee saveEmp(Employee employee) {
		return emprepo.save(employee);
	}
	
	
	
	public List<Employee> saveAllEmp(List<Employee> employeelist){
		return emprepo.saveAll(employeelist);
	}
	
	
	
	public List<Employee> getAllEmployees(){
		return emprepo.findAll();
	}
	
	
	
	public Employee getEmployeeById(int id) {
		return emprepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
	}
	
	
	public Employee updateEmployee(int id, Employee updatedEmployee) {
		
		Employee existingEmp = emprepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		
		// Update fields (modify according to your entity fields)
		existingEmp.setName(updatedEmployee.getName());
		//existingEmp.setSalary(updatedEmployee.getSalary());
		existingEmp.setEmail(updatedEmployee.getEmail());
		
		return emprepo.save(existingEmp);
	}
	
	
	 
	public void deleteEmployee(int id) {
		
		Employee employee = emprepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		
		emprepo.delete(employee);
	}
	
	
	// Optional direct delete
	public void deleteEmp(Employee employee) {
		emprepo.delete(employee);
	}

}