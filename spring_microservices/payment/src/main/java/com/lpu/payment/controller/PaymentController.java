package com.lpu.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.payment.entity.Payment;
import com.lpu.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	  @Autowired
	  private PaymentService service;
	  
	  @PostMapping("/save")
	  public Payment savePayment(@RequestBody Payment payment) {
		     return service.savePayment(payment);
	  }
	  
	  
	  @GetMapping("/find/{id}")
	  public Payment findPayment(@PathVariable int id) {
		       return service.findPayment(id);
	  }
	  
	  
}

