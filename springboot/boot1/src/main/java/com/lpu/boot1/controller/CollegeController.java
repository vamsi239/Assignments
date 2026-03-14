package com.lpu.boot1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.boot1.entity.College;
import com.lpu.boot1.service.CollegeService;

@RestController
@RequestMapping("/sm")
public class CollegeController {
	@Autowired
	private CollegeService cserv;
	
	@PostMapping("/college")
	public College savecol(@RequestBody College college) {
		return cserv.saveCol(college);
	}
	
	@PostMapping("/colleges")
	public List<College> saveAllcol(@RequestBody List<College> college){
		return cserv.saveAllCol(college);
		
	}
	

	
	

}
