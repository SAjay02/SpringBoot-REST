package com.student.mycart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.mycart.commonresponse.Response;
import com.student.mycart.enumeration.ResponseStatus;
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
	
	@GetMapping("/type/{category}")
	public Response getSpecificProduct(@PathVariable String category)
	{
		Response apiResponse = new Response();
		
		try
		{
			apiResponse = productService.getSpecificProduct(category);
		}
		catch(Exception e)
		{
			apiResponse.setStatuscode(500);
			apiResponse.setData(e.getMessage());
			apiResponse.setError(ResponseStatus.FAILED);
			apiResponse.setSuggestion("Please try again later or contact support");
			apiResponse.setDescription("An error occured");
		}
		return apiResponse;
	}
	
	@PostMapping("/createProduct")
	public Product createUser(@RequestBody Product product)
	{
		Product newProduct = productService.createProduct(product); 
		return newProduct;
	}
	
	
}
