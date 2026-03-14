package com.lpu.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lpu.orderservice.dto.BookDTO;

@FeignClient(name = "BOOKSERVICE")
public interface BookFeignClient {

    @GetMapping("/books/find/{id}")
    BookDTO getBookById(@PathVariable Long id);
}