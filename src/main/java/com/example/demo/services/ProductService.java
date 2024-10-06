package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.Controller;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductImage;
import com.example.demo.repository.ProductImageRepo;
import com.example.demo.repository.ProductRepo;

import jakarta.transaction.Transactional;


@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ProductImageRepo productImageRepo;
	

	Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	
	public List<Product> getProducts()
	{
		List<Product> list = new ArrayList<>();
		list = (List<Product>) productRepo.findAll();
		return list;
		
	}
	
	@Transactional
	public Boolean saveProduct(ProductDTO productDTO)
	{
		logger.debug("productDTO is ---------- "+productDTO.toString());
		Product product = new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setDiscountPercentage(productDTO.getDiscountPercentage());
		product.setPrice(productDTO.getPrice());
		product.setRating(productDTO.getRating());
		
		Product updatedProduct = productRepo.save(product);
		logger.debug("saved product is ---------- "+updatedProduct.toString());
		
		
		List<ProductImage> productImageList = new ArrayList<>();
		for(String imageUrlString : productDTO.getProductImages())
		{
			ProductImage productImage = new ProductImage();
			productImage.setImagePath(imageUrlString);
			productImage.setProduct(updatedProduct);
			productImageList.add(productImage);
			
		}

		logger.debug("Before saving  images is ---------- "+productImageList.toString());
		
		productImageList = productImageRepo.saveAll(productImageList);
		

		logger.debug("saved images is ---------- "+productImageList.toString());
		return true;
		
	}

}
