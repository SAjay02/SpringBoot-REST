package com.student.mycart.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.mycart.commonresponse.Response;
import com.student.mycart.models.Product;
import com.student.mycart.repositories.ProductRepository;
import com.student.mycart.enumeration.ResponseStatus;

@Service
public class ProductServices {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
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
}
