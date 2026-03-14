package com.lpu.demosecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {
	@GetMapping("/hi")
	public String demo() {
		return "hi page";
	}
	
	@GetMapping("/home")
	public String demo1() {
		return "home page";
	}
	
	@GetMapping("/reg")
	public String register() {
		return "Register page";
	}
}
