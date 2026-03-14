package com.lpu.bookservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.bookservice.entity.Book;
import com.lpu.bookservice.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public Book findbyid(Long id) {
		return bookRepository.findById(id).orElseThrow();
	}
	
	public List<Book> findall() {
		return bookRepository.findAll();
	}
	
	public List<Book> saveBooks(List<Book> book) {
		return bookRepository.saveAll(book);
	}
	
	public Book updateBooks(Long id) {
		Book b=new Book();
		Book updated=bookRepository.findById(id).orElseThrow();
		
		updated.setPrice(b.getPrice());
		updated.setQuantity(b.getQuantity());
		
		return bookRepository.save(updated);
	}
	
	public void deletebyid(Long id) {
		//Book b=new Book();
		bookRepository.deleteById(id);
		
	}
	
	
}
