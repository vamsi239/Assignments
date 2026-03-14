package com.bookstore.orderservice.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.orderservice.config.RabbitConfig;
import com.bookstore.orderservice.model.Order;

@Service
public class OrderProducer {

	@Autowired
	private RabbitTemplate template;
	
	public void sendOrder(Order order) {
		template.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTING_KEY, order);
		
		System.out.println("Order sent to RabbitMQ");
	}
}
