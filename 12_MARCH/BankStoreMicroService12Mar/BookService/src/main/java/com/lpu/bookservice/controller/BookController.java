package com.lpu.bookservice.controller;

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

import com.lpu.bookservice.entity.Book;
import com.lpu.bookservice.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookservice;
	
	//find By Id
	@GetMapping("/find/{id}")
	public Book findbyid1(@PathVariable Long id) {
		return bookservice.findbyid(id);
	}
	
	//find All Books
	@GetMapping("/find")
	public List<Book> findall1(){
		return bookservice.findall();
		
	}
	
	//save Books
	@PostMapping("/save")
	public List<Book> save1(@RequestBody List<Book> books){
		return bookservice.saveBooks(books);
	}
	
	//Update Books
	@PutMapping("/update/{id}")
	public Book update1(@PathVariable Long id) {
		return bookservice.updateBooks(id);
	}
	
	//delete Books
	@DeleteMapping("/delete/{id}")
	public void delete1(@PathVariable Long id) {
		 bookservice.deletebyid(id);
	}
	
}
