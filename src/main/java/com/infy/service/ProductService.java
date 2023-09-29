package com.infy.service;

import java.util.List;

import com.infy.entity.ProductEntity;

public interface ProductService {

	public List<ProductEntity> getAllProducts();

	public boolean createProduct(ProductEntity product);

	public ProductEntity getProductById(int id);

	public List<ProductEntity> getProductByName(String name);

	public List<ProductEntity> getAllSortedProducts(String sortBy, String sortDir);

//	public List<ProductEntity> getAllProductsSortedAndPaginated(int pageSize, int pageNo, String sortBy,
//			String sortDir);

	public List<ProductEntity> getProductByNameAndPrice(String name, float price);
}
