package com.bookstore.orderservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	public static final String EXCHANGE = "book_exchange";
	public static final String QUEUE_NAME = "order_queue";
	public static final String ROUTING_KEY = "order_created";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, true);
	}
	
	@Bean
	public MessageConverter jsonMeassageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(EXCHANGE);
	}
	
	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
}
