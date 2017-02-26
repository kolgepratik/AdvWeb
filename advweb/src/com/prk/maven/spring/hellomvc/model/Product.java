package com.prk.maven.spring.hellomvc.model;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private String name;
	private String brand;
	private Integer cost;

	public Product(String name, String brand, int cost) {
		super();
		this.name = name;
		this.brand = brand;
		this.cost = cost;
	}

	public Product() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", brand=" + brand + ", cost=" + cost + "]";
	}
}
