package com.student.mycart;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.student.mycart.models.Product;
import com.student.mycart.repositories.ProductRepository;

@Component
public class DataAdd implements CommandLineRunner{
	
	@Autowired
	private ProductRepository ProductRepository;
	
	@Override
	public void run(String ...args) throws Exception
	{
		if(ProductRepository.count()==0)
		{
			//add data 
			List<Product>product =  Arrays.asList(
					new Product("Galaxy",16000,"Camera",3.8,"Samsung","Us",60,3000),
					new Product("One plus",16000,"Gaming",4.5,"One","Uk",80,5000)
					);
			ProductRepository.saveAll(product);
			
		}
	}
}
