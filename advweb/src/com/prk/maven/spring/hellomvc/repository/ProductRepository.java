package com.prk.maven.spring.hellomvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.prk.maven.spring.hellomvc.model.Product;

@Component
public class ProductRepository {
	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();

		Product p = new Product();
		p.setName("Echo");
		p.setBrand("Amazon");
		p.setCost(150);
		list.add(p);

		p = new Product();
		p.setName("Home");
		p.setBrand("Google");
		p.setCost(99);
		list.add(p);

		return list;
	}
}
