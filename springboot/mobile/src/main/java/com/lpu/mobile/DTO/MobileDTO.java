package com.lpu.mobile.DTO;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class MobileDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @NotBlank(message="Brand name is required")
    private String brandName;

    @NotBlank(message="Model name is required")
    private String modelName;

    @Positive(message="Price must be greater than 0")
    private double price;

    @NotBlank(message="RAM is required")
    private String ram;

    @NotBlank(message="Storage is required")
    private String storage;

    @NotBlank(message="Color is required")
    private String color;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    // getters setters
    
}