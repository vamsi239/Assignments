package com.lpu.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.lpu.payment.entity.Payment;
import com.lpu.payment.repository.PaymentRepository;

@Service
public class PaymentService {

	   @Autowired
	   private PaymentRepository repo;
	   
	   public Payment savePayment(Payment payment) {
		    return repo.save(payment);
	   }
	   
	   public Payment findPayment(int id) {
		     return repo.findById(id).orElseThrow(()->new IllegalArgumentException());
	   }
}
