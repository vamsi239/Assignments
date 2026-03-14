package com.bookstore.bookservice.cllient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookstore.bookservice.dto.OrderDTO;

@FeignClient(name = "orderservice", path = "/api/orders")
public interface OrderInterfaceClient {
	
	@PostMapping
	public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO order);
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> findOrderById(@PathVariable long id);
	
	@GetMapping
	public List<OrderDTO> findOrders();
	
	@PutMapping("/{id}")
	public ResponseEntity<OrderDTO> updateOrderById(@PathVariable long id, @RequestBody OrderDTO order);
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<Void> deleteOrderById(@PathVariable long id);

}
