package com.student.mycart.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.student.mycart.models.Product;
import com.student.mycart.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired 
	private ProductServices productService;
	 
	@GetMapping
	public List<Product> getAllproducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/category")
	public List<Product> getSpecificProduct()
	{
		return productService.getSpecificProduct();
	}
}
