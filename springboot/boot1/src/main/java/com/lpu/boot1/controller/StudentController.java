package com.lpu.boot1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.boot1.entity.Student;
import com.lpu.boot1.service.StudentService;


@RestController
@RequestMapping("/sm")
public class StudentController {
	
	@Autowired
	private StudentService serv;
	
	@PostMapping("/student")
	public Student saves(@RequestBody Student student) {
		return serv.saveStu(student);
	}
	
	@GetMapping("/student")
	public Student get(@RequestHeader int id) {
		return serv.findStu(id);
	}
	
	@GetMapping("/students")
	public List<Student> findwithName(@RequestHeader  String name){
		return serv.findbyName(name);
	}
	
	
	
	

}
