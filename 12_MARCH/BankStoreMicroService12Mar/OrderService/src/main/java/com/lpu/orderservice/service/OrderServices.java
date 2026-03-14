package com.lpu.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.orderservice.entity.Orders;
import com.lpu.orderservice.repository.OrderRepository;
@Service
public class OrderServices {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Orders> findAllOrders(){
		return orderRepository.findAll();
	}
	
	public Orders findOrderById(Long id) {
		return orderRepository.findById(id).orElseThrow();
	}
	
	public List<Orders> saveOrders(List<Orders> orders){
		return orderRepository.saveAll(orders);
	}
	
	public Orders updateOrdersById(Long id) {
		Orders orders=new Orders();
		
		Orders updated=orderRepository.findById(id).orElseThrow();
		updated.setQuantity(orders.getQuantity());
		updated.setTotalPrice(orders.getTotalPrice());
		
		return orderRepository.save(updated);
	}
	
	public void deleteOrdersById(Long id) {
		 orderRepository.deleteById(id);
	}
}
