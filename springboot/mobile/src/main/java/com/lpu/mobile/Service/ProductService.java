package com.lpu.mobile.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.lpu.mobile.Entity.Product;
import com.lpu.mobile.Repository.ProductRepo;

@Service
public class ProductService {
	private final ProductRepo productRepo;

	@Autowired
	public ProductService(ProductRepo productRepo) {
		super();
		this.productRepo = productRepo;
	}
	
	public List<Product> saveAllProduct(List<Product> products){
		return productRepo.saveAll(products);
	}
	
	public List<Product> productPagination(int pageNumber,int size) {
		Pageable pageable=PageRequest.of(pageNumber, size);
		return productRepo.findAll(pageable).getContent();
		
		
	}
	
	public List<Product> sortProductPage(int pageNumber,int size,String field){
		Pageable pageable=PageRequest.of(pageNumber, size,Sort.by(field).descending());
		return productRepo.findAll(pageable).getContent();
	}
	
	public List<Product> sortProductByfieldInDesc(String field){
		return productRepo.findAll(Sort.by(field).descending());
	}
	
	public List<Product> sortProductByfieldInAsc(String field){
		return productRepo.findAll(Sort.by(field).ascending());
	}
}
