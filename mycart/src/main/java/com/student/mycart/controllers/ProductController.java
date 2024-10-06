package com.student.mycart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Response getAllproducts()
	{
		Response apiResponse = new Response();
		
		try
		{
			apiResponse = productService.getAllProducts();
		}
		catch(Exception e)
		{
			apiResponse.setStatuscode(500);
			apiResponse.setData(e.getMessage());
			apiResponse.setError(ResponseStatus.FAILED);
			apiResponse.setSuggestion("Please try again later or contact support");
			apiResponse.setDescription("An error occured while getting all products");
		}
		return apiResponse;
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
			apiResponse.setDescription("An error occured while getting the products");
		}
		return apiResponse;
	}
	
	@PostMapping("/createProduct")
	public Response createUser(@RequestBody Product product)
	{
		Response  apiResponse = new Response();
		
		try
		{
			Product newProduct = productService.createProduct(product);
			apiResponse.setStatuscode(201);
			apiResponse.setData(newProduct);
			apiResponse.setError(ResponseStatus.SUCCESS + " - Product Created");
	        apiResponse.setDescription("The product was successfully created.");
			
		}
		catch(Exception e)
		{
			apiResponse.setStatuscode(500);
	        apiResponse.setData(e.getMessage());
	        apiResponse.setError(ResponseStatus.FAILED + " - Creation Failed");
	        apiResponse.setSuggestion("Please try again later or contact support");
	        apiResponse.setDescription("An error occurred while creating the product.");
		}
		
		return apiResponse;
	}
	
		@PutMapping("/updateproduct/{name}")
		public Response updateProduct(@PathVariable String name , @RequestBody Product product)
		{
			Response apiResponse = new Response();
			
			try
			{
				apiResponse = productService.updateProduct(name,product);
			}
			catch(Exception e)
			{
				apiResponse.setStatuscode(500);
		        apiResponse.setData(e.getMessage());
		        apiResponse.setError(ResponseStatus.FAILED + " - Creation Failed");
		        apiResponse.setSuggestion("Please try again later or contact support");
		        apiResponse.setDescription("An error occurred while updating the product.");
			}
			
			return apiResponse;
		}
		
		@DeleteMapping("/deleteproduct/{name}")
		public Response deleteProduct(@PathVariable String name)
		{
			Response apiResponse = new Response();
			
			try
			{
				apiResponse = productService.deleteProduct(name);
			}
			catch(Exception e)
			{
				apiResponse.setStatuscode(500);
		        apiResponse.setData(e.getMessage());
		        apiResponse.setError(ResponseStatus.FAILED + " - Creation Failed");
		        apiResponse.setSuggestion("Please try again later or contact support");
		        apiResponse.setDescription("An error occurred while deleting the product.");
			}
			
			return apiResponse;
		}
	
}
