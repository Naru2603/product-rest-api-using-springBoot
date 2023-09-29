package com.infy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static com.infy.util.Constants.*;

import com.infy.entity.ProductEntity;
import com.infy.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.extern.log4j.Log4j2;

@Tag(name = "Product", description = "Product management/CRUD APIs")
@Log4j2
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Operation(
			summary = "Retrive all Products",
			method = "getProducts",
			description = "Gets the list of all Products!!"
			)
	  @ApiResponses({
		    @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ProductEntity.class), mediaType = "application/json") }),
		    @ApiResponse(responseCode = "404", description = "Error while fetching the Products.", content = { @Content(schema = @Schema()) })
		  })

	@GetMapping("/products")
	public ResponseEntity<List<ProductEntity>> getProducts() {

		log.info("Request received to fetch all Products");
		List<ProductEntity> prodList = productService.getAllProducts();
		return new ResponseEntity<List<ProductEntity>>(prodList, HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductEntity> getProductById(@PathVariable int id) {

		log.info("Request received to fetch Product by Id");
		ProductEntity retrivedProduct = productService.getProductById(id);
		return new ResponseEntity<ProductEntity>(retrivedProduct, HttpStatus.OK);
	}
	
	@GetMapping("/products/name")
	public ResponseEntity<List<ProductEntity>> getProductByName(@RequestParam String name) {

		log.info("Request received to fetch Product by name");
		List<ProductEntity> prodList = productService.getProductByName(name);
		return new ResponseEntity<List<ProductEntity>> (prodList, HttpStatus.OK);
	}
	
	@GetMapping("/products/name_price")
	public ResponseEntity<List<ProductEntity>> getProductByNameAndPrice(@RequestParam String name, float price) {

		log.info("Request received to fetch Product by name and price");
		List<ProductEntity> prodList = productService.getProductByNameAndPrice(name, price);
		return new ResponseEntity<List<ProductEntity>> (prodList, HttpStatus.OK);
	}
	
	
	@PostMapping("/products")
	public ResponseEntity<String> createProduct(@RequestBody ProductEntity product) {

		log.info("Request received to store the Product : {}", product);
		String res = (productService.createProduct(product)) ? SUCCESSFULLY_STORED: ERROR_WHILE_STORING;
		return new ResponseEntity<String>(res, HttpStatus.CREATED);
	}
	
	@GetMapping("/products/sort")
	public ResponseEntity<List<ProductEntity>> getAllSortedProducts(@RequestParam String sortBy, String sortDir) {

		log.info("Request received to fetch all Products");
		List<ProductEntity> prodList = productService.getAllSortedProducts(sortBy, sortDir);
		return new ResponseEntity<List<ProductEntity>>(prodList, HttpStatus.OK);
	}
	
//	@GetMapping("/products/sort")
//	public ResponseEntity<List<ProductEntity>> getAllProductsSortedAndPaginated(@RequestParam String sortBy, 
//			@RequestParam String sortDir,
//			@RequestParam int pageSize,
//			@RequestParam int pageNo ) {
//
//		log.info("Request received to fetch all Products with sorting and Pagination techniq");
//		List<ProductEntity> prodList = productService.getAllProductsSortedAndPaginated(pageSize, pageNo, sortBy,sortDir);
//		return new ResponseEntity<List<ProductEntity>>(prodList, HttpStatus.OK);
//	}
}
