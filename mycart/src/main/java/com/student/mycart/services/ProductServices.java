package com.student.mycart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.mycart.commonresponse.Response;
import com.student.mycart.enumeration.ResponseStatus;
import com.student.mycart.models.Product;
import com.student.mycart.repositories.ProductRepository;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Response getAllProducts()
	{
		Response apiResponse = new Response();
		
		List<Product> product = productRepository.findAll();
		
		if(!product.isEmpty())
		{
			apiResponse.setData(product);
			apiResponse.setDescription("Retrieved Successfully");
		}
		else
		{
			apiResponse.setStatuscode(404);
			apiResponse.setError(ResponseStatus.FAILED+" - Not Found");
			apiResponse.setSuggestion("Plese check your given type");
			apiResponse.setDescription("Given type never been in the DB");
		}
		return apiResponse;
	}
	
	public Response getSpecificProduct(String category)
	{
		
		Response apiResponse = new Response();
		
		List<Product> product = productRepository.findByCategory(category);

		if(!product.isEmpty())
		{
			apiResponse.setData(product);
		}
		else
		{
			apiResponse.setStatuscode(404);
			apiResponse.setError(ResponseStatus.FAILED+" - Not Found");
			apiResponse.setSuggestion("Plese check your given type");
			apiResponse.setDescription("Given type never been in the DB");
		}
		return apiResponse;
	}
	
	public Product createProduct(Product product)
	{
		return productRepository.save(product);
	}
	
	public Response updateProduct(String name,Product product)
	{
		Response apiResponse = new Response();
		
		List<Product> products = productRepository.findByName(name);
		
		if(!products.isEmpty())
		{
			
			Product existingProduct = products.get(0);
			
			existingProduct.setCategory(product.getCategory());
			
			productRepository.save(existingProduct);
			
			apiResponse.setData(existingProduct);
	        apiResponse.setError(ResponseStatus.SUCCESS + " - Product Updated");
	        apiResponse.setDescription("The product was successfully updated.");
		}
		else
		{
			apiResponse.setStatuscode(404);
			apiResponse.setError(ResponseStatus.FAILED+" - Not Found");
			apiResponse.setSuggestion("Plese check your given type");
			apiResponse.setDescription("Given type never been in the DB");
		}
		
		return apiResponse;
		
	}
	
	@Transactional
	public Response deleteProduct(String name)
	{
		Response apiResponse = new Response();
		
		List<Product> product = productRepository.findByName(name);
		
		if(!product.isEmpty())
		{
			Product existingProduct = product.get(0);
			
			productRepository.deleteByName(existingProduct.getName());
			apiResponse.setData(existingProduct);
		}
		else
		{
			apiResponse.setStatuscode(404);
			apiResponse.setError(ResponseStatus.FAILED+" - Not Found");
			apiResponse.setSuggestion("Plese check your given type");
			apiResponse.setDescription("Given type never been in the DB");
		}
		
		return apiResponse;
	}
}
