package com.lpu.boot1.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.boot1.entity.College;
import com.lpu.boot1.repository.CollegeRepo;

@Service
public class CollegeService {
	
	@Autowired
	private CollegeRepo Crepo;
	
	public College saveCol(College college) {
		return Crepo.save(college);
	}
	public List<College> saveAllCol(List<College> college){
		return Crepo.saveAll(college);
	}
	
	public void deleteCol() {
		Crepo.deleteAll();
	}
	public void deleteColId(int id) {
		Crepo.deleteById(id);
	}
	public College findCol(int id) {
		return Crepo.findById(id).orElse(null);
	}
	
	public List<College> findallCol(){
		return Crepo.findAll();
	}
	
	
	

}
