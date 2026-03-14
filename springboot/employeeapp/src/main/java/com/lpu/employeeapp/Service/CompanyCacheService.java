package com.lpu.employeeapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lpu.employeeapp.Entity.Company;

@Service
public class CompanyCacheService {
    @Autowired
    private CompanyService companyService;

    @Cacheable(value = "companyCache", key = "#id")
    public Company getCompanyById(int id) {
        System.out.println("Fetching from DB...");
        return companyService.findCmpByid(id);
    }

    @CachePut(value = "companyCache", key = "#id")
    public Company updateCompany(int id, Company company) {
        return companyService.saveCmp(company);
    }

    @CacheEvict(value = "companyCache", key = "#id")
    public void deleteCompany(int id) {
        System.out.println("Cache removed for id: " + id);
    }
}