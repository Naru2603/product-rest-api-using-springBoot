package com.infy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{

//	public List<ProductEntity> getAllProductsFromDb();
//
//	public boolean createProduct(ProductEntity product);
	
	public List<ProductEntity> findByName(String name);
	
	public List<ProductEntity> findByNameAndPrice(String name, float price);
}
