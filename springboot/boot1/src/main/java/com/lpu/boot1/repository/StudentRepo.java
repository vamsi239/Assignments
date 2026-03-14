package com.lpu.boot1.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.boot1.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
//custom method
List<Student> findByName(String name);
Student findByNameAndPhone(String name,String phone);

//custom Query
@Query("select s from Student s where s.name = :name")
List<Student> findByname(String name);

//custom SQL Query
@Query(nativeQuery=true,value= "select * from Student")
List<Student> findBynname(String name);

}
