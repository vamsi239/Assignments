package com.lpu.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Payment {

	 @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	     private int id;
	     private String payment;
	     private double amount;
	     
	    
		 public Payment() {
			super();
		}
		 public int getId() {
			 return id;
		 }
		 public void setId(int id) {
			 this.id = id;
		 }
		 public String getPayment() {
			 return payment;
		 }
		 public void setPayment(String payment) {
			 this.payment = payment;
		 }
		 public double getAmount() {
			 return amount;
		 }
		 public void setAmount(double amount) {
			 this.amount = amount;
		 }
	     
	     
}

