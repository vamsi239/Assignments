package com.lpu.mobile.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.mobile.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
