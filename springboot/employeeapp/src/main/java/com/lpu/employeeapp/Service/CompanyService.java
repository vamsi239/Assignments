package com.lpu.employeeapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lpu.employeeapp.Entity.Company;
import com.lpu.employeeapp.Entity.Employee;
import com.lpu.employeeapp.Repository.CompanRepo;

@Service
public class CompanyService {
	
	@Autowired
	private CompanRepo cmprepo;
	
	
	
	public Company saveCmp(Company company) {
		return cmprepo.save(company);
	}
	
	
	
	public Company saveCmpAndMapWithEmp(Company company) {
		
		if (company.getEmployeelist() != null) {
			company.getEmployeelist()
			       .forEach(emp -> emp.setCompany(company));
		}
		
		return cmprepo.save(company);
	}
	
	
	
	public Company saveEmptoExistingCmp(int id, List<Employee> newEmplist) {
		
		Company company = cmprepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
		
		if (newEmplist != null) {
			newEmplist.forEach(emp -> emp.setCompany(company));
			company.getEmployeelist().addAll(newEmplist);
		}
		
		return cmprepo.save(company);
	}
	
	
	
	public Company findCmpByid(int id) {
	    System.err.println("Fetching from DB...");
	    return cmprepo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));
	}

}