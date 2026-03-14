package com.lpu.employeeapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.employeeapp.Entity.Company;

public interface CompanRepo extends JpaRepository<Company,Integer> {

}
