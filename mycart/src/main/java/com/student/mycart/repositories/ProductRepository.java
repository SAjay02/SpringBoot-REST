package com.student.mycart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.student.mycart.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
	
}	
