package com.student.mycart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.mycart.models.Product;
import com.student.mycart.repositories.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	
	public List<Product> getSpecificProduct(String category)
	{
		return productRepository.findByCategory(category);
	}
}
