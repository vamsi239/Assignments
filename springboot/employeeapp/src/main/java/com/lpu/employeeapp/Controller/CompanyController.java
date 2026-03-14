package com.lpu.employeeapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lpu.employeeapp.Entity.Company;
import com.lpu.employeeapp.Entity.Employee;
import com.lpu.employeeapp.Service.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    private CompanyService cmpservice;

    
    @PostMapping("/company")
    public ResponseEntity<Company> saveEMP(@RequestBody Company company) {

        Company com = cmpservice.saveCmp(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(com);
    }

    
    @PostMapping("/company1")
    public ResponseEntity<Company> savCMPWITHMap(@RequestBody Company company) {

        Company savedCompany = cmpservice.saveCmpAndMapWithEmp(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompany);
    }

    
    @PostMapping("/company2/{id}")
    public ResponseEntity<Company> saveEMPtoExistingCMP(
            @PathVariable int id,
            @RequestBody List<Employee> employee) {

        Company updatedCompany = cmpservice.saveEmptoExistingCmp(id, employee);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCompany);
    }

    
    @GetMapping("/divide/{one}/{two}")
    public ResponseEntity<Integer> AIRTHMETICEXC(
            @PathVariable int one,
            @PathVariable int two) {

        int result = one / two;
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    
    @GetMapping("/company/exception/{id}")
    public ResponseEntity<Company> findCmpById(@PathVariable int id) {

        Company company = cmpservice.findCmpByid(id);
        return ResponseEntity.status(HttpStatus.OK).body(company);
    }

}