package com.student.mycart.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.mycart.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	
	//get items by category
	List<Product> findByCategory(String category);
	
	//get items by name and update it
	List<Product> findByName(String name);
	
	//delete items by name
	void deleteByName(String name);
}	
