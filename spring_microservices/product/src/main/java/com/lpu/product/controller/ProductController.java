package com.lpu.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.product.entity.Product;
import com.lpu.product.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {

	  @Autowired
	  private ProductService service;
	  
	  @PostMapping("/save")
	  public Product saveProduct(@RequestBody Product product) {
		     return service.saveProduct(product);
	  }
	  
	  
	  @GetMapping("/find/{id}")
	  public Product findProduct(@PathVariable int id) {
		       return service.findProduct(id);
	  }
	  
	  
}

