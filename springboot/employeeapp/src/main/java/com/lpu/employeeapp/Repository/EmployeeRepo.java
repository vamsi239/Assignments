package com.lpu.employeeapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.employeeapp.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
