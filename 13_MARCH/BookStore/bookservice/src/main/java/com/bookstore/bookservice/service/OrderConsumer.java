package com.bookstore.bookservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookservice.config.RabbitConfig;
import com.bookstore.bookservice.dto.OrderDTO;
import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.repository.BookRepository;

@Service
public class OrderConsumer {

	@Autowired
	private BookRepository repository;
	
	@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
	public void receiveOrder(OrderDTO order) {
		Book book = repository.findById(order.getBookId()).orElse(null);
		
		if (book != null) {
            book.setQuantity(book.getQuantity() - order.getQuantity());
            repository.save(book);
        }

        System.out.println("Stock updated after order");
	}
}
