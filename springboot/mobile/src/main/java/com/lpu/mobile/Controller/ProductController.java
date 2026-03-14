package com.lpu.mobile.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.mobile.Entity.Product;
import com.lpu.mobile.Service.ProductService;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productservice;

    @PostMapping
    public List<Product> saveAllPro(@RequestBody List<Product> list){
        return productservice.saveAllProduct(list);
    }

    @GetMapping("/page/{pageNumber}/{size}")
    public List<Product> productPage(
            @PathVariable int pageNumber,
            @PathVariable int size){
        
        return productservice.productPagination(pageNumber, size);
    }
    
    @GetMapping("/sort/{field}")
    public List<Product> sortProductInDesc(@PathVariable String field){
    	return productservice.sortProductByfieldInDesc(field);
    }
    
    @GetMapping("/sort/asc/{field}")
    public List<Product> sortProductInAsc(@PathVariable String field){
    	return productservice.sortProductByfieldInAsc(field);
    }
}