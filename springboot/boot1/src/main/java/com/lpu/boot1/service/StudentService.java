package com.lpu.boot1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.boot1.entity.Student;
import com.lpu.boot1.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;

	
	public Student saveStu(Student student) {
		return repo.save(student);
	}
	
	public Student findStu(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public void deleteStu(int id) {
		repo.deleteById(id);
	}
	
	
	public List<Student> findAllStu(Student student){
		return repo.findAll();
	}
	
	public List<Student> findbyName(String name){
		return repo.findBynname(name);
	}

	
}
