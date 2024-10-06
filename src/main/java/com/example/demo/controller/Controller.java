package com.example.demo.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/api/v1")
public class Controller {
	@Autowired
	ProductService service;
	Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@GetMapping("/getProducts")
	public List<Product> getProducts()
	{
		
		return service.getProducts();
		
	}
	
	@PostMapping("/saveProduct")
	public String saveProducts(@RequestBody ProductDTO productDTO)
	{
		
		logger.debug("Product Details from API  : " + productDTO);
		boolean result =  service.saveProduct(productDTO);
		String message = result ? "Product saved successfully !": "Issue while saving the product";
		return message;
		
		
	}

}
