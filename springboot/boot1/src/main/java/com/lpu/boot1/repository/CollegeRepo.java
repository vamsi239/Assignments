package com.lpu.boot1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.boot1.entity.College;

public interface CollegeRepo extends JpaRepository<College, Integer> {

}
