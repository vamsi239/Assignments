package com.lpu.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.orderservice.entity.Orders;
import com.lpu.orderservice.service.OrderServices;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderServices orderService;
	
	//find by id
	@GetMapping("/find/{id}")
	public Orders getOrderById1(@PathVariable Long id) {
		return orderService.findOrderById(id);
	}
	
	//Find All Orders
	@GetMapping("/find")
	public List<Orders> getAllOrders(){
		return orderService.findAllOrders();
	}
	
	//save all 
	@PostMapping("/save")
	public List<Orders> saveAllOrders1(@RequestBody List<Orders> orders){
		return orderService.saveOrders(orders);
	}
	
	//update by id
	@PutMapping("/update/{id}")
	public Orders update1(@PathVariable Long id) {
		return orderService.updateOrdersById(id);
	}
	
	//delete by id
	@DeleteMapping("/delete/{id}")
	public void deleteOrders(@PathVariable Long id) {
		 orderService.deleteOrdersById(id);
	}
	
}
