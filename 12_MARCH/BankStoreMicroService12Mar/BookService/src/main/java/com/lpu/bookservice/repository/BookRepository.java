package com.lpu.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.bookservice.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
