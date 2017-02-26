/**
 * 
 */
package com.prk.maven.spring.hellomvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.prk.maven.spring.hellomvc.model.Product;
import com.prk.maven.spring.hellomvc.service.ProductService;
import com.prk.maven.spring.hellomvc.util.AppWrappers;

/**
 * @author kolge
 *
 */
@Controller
public class ProductController {

	static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private AppWrappers appWrappers;

	@Autowired
	private ProductService productService;

	@Autowired
	private Product product;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", productService.findAll());

		return "views/productList";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("product", product);
		return "views/addProduct";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Product product, Model model) {
		LOG.debug("Name: {}. Brand: {}. Cost: {}", product.getName(), product.getBrand(), product.getCost());
		System.out
				.println("Name: {}. Brand: {}. Cost: {}" + product.getName() + product.getBrand() + product.getCost());
		model.addAttribute("list", productService.findAll());

		return "views/productList";
	}
}
