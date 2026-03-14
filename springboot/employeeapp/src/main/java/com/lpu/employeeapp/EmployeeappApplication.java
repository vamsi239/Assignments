package com.lpu.employeeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmployeeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeappApplication.class, args);
	}

}

