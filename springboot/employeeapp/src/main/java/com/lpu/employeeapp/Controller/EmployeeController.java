package com.lpu.employeeapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lpu.employeeapp.Entity.Employee;
import com.lpu.employeeapp.Service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empservice;
	
	
	
	@PostMapping("/emp")
	public ResponseEntity<Employee> saveEmp(@Valid @RequestBody Employee employee){
		
		Employee emp = empservice.saveEmp(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(emp);
	}
	
	
	
	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> employees = empservice.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(employees);
	}
	
	
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		
		Employee employee = empservice.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
	
	
	
	@PutMapping("/emp/{id}")
	public ResponseEntity<Employee> updateEmployee(
			@PathVariable int id,
			@Valid @RequestBody Employee employee){
		
		Employee updatedEmp = empservice.updateEmployee(id, employee);
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmp);
	}
	 
	
	
	@DeleteMapping("/emp/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		
		empservice.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
				.body("Employee deleted successfully");
	}

}