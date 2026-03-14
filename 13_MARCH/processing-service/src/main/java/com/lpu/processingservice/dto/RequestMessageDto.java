package com.lpu.processingservice.dto;


public class RequestMessageDto {
	private String mobileNumber;
	private double amount;
	private String operator;
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public RequestMessageDto() {
		super();
	}
	
	
}

