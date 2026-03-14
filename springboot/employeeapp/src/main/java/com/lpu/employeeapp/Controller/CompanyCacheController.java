package com.lpu.employeeapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lpu.employeeapp.Entity.Company;
import com.lpu.employeeapp.Service.CompanyCacheService;

@RestController
@RequestMapping("/api/cache/company")
public class CompanyCacheController {

    @Autowired
    private CompanyCacheService cacheService;

    
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable int id) {
        return ResponseEntity.ok(cacheService.getCompanyById(id));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(
            @PathVariable int id,
            @RequestBody Company company) {

        return ResponseEntity.ok(cacheService.updateCompany(id, company));
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCache(@PathVariable int id) {
        cacheService.deleteCompany(id);
        return ResponseEntity.ok("Cache cleared");
    }
}