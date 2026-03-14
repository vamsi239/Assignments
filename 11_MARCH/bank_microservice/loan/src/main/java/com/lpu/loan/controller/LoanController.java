package com.lpu.loan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/loan")
@RestController
public class LoanController {
	@GetMapping("/save2")
	public String hi2() {
		return "hi2";
	}
}
