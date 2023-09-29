package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.infy.dao.ProductRepository;
import com.infy.entity.ProductEntity;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public ProductEntity getProductById(int id) {
		log.info("inside service - getProductsById");
		Optional<ProductEntity> fetchedProduct = productRepository.findById(id);

		return fetchedProduct.get();
	}

	@Override
	public List<ProductEntity> getProductByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public boolean createProduct(ProductEntity product) {
		log.info("inside service - createProduct()");
		ProductEntity saveProduct = productRepository.save(product);
		return Objects.nonNull(saveProduct);
	}

	@Override
	public List<ProductEntity> getAllSortedProducts(String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		return productRepository.findAll(sort);
	}

//	@Override
//	public List<ProductEntity> getAllProductsSortedAndPaginated(int pageSize, int pageNo, String sortBy,
//			String sortDir) {
//		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
//                : Sort.by(sortBy).descending();
//		
//		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
//		Page<ProductEntity> posts = productRepository.findAll(pageable);
//		
//		return new ArrayList<>();
//	}

	@Override
	public List<ProductEntity> getProductByNameAndPrice(String name, float price) {
		return productRepository.findByNameAndPrice(name, price);
	}
	
	
}
