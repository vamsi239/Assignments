package com.lpu.boot1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lpu")
public class LpuController {
	
	//URL-> http://localhost:8080/lpu/m1
	@RequestMapping("/m1")
	public String m1() {
		return "hello!";
	}
	
	//URL-> http://localhost:8080/lpu/student
	@PostMapping("/student")
	public String student() {
		return "student saved";
	}

	

}
