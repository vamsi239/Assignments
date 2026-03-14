package com.lpu.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.product.entity.Product;
import com.lpu.product.repository.ProductRepository;

@Service
public class ProductService {

	  @Autowired
	private ProductRepository repo;
	
	  public Product saveProduct(Product product) {
		    return repo.save(product);
	  }
	  
	  public Product findProduct(int id) {
		     return repo.findById(id).orElseThrow(()->new IllegalArgumentException("not found"));
	  }
}
