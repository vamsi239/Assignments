package com.lpu.employeeapp.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	//500 Internal Server Error
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Map<String, String>> handelArithmeticException(ArithmeticException ex){
		Map<String, String> map = new HashMap<>();
		map.put("Error: ", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
	}
	
	//404 Not Found
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<Map<String, String>> handelCompnayNotFoundException(CompanyNotFoundException cex){
		Map<String, String> map = new HashMap<>();
		map.put("Error: ", cex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handelMethodArgumentNotValidException(MethodArgumentNotValidException cex){
		Map<String, String> map = new HashMap<>();
//		map.put("Error: ", cex.getMessage());
		cex.getBindingResult().getFieldErrors()
		.forEach(error ->map.put(error.getField(), error.getDefaultMessage()));
		return map;
	}
	
	@ExceptionHandler(Exception.class)
	public Map<String, String> handelAllException(Exception e){
		Map<String, String> map = new HashMap<>();
		map.put("Error: ", e.getMessage());
		return map;
	}
	
	
	//402 PAyment Required
	//403 Forbidden
	//405 Method Not Allowed
	//408 Request Time Out
	//500 Internal Server Error
	//502 Bad Gateway
	//503 Service Unavailable
	//504 Gateway Time Out
	

	
	
	
	
	
	
	
	
	
}