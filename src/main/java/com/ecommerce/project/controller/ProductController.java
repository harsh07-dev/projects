package com.ecommerce.project.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.controller.repository.ProductRepo;
import com.ecommerce.project.model.Product;
import com.ecommerce.project.payloadDTO.ProductDto;
import com.ecommerce.project.payloadDTO.ProductResponse;
import com.ecommerce.project.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService productService;

	@Autowired
	ProductRepo productRepo;

	@Autowired
	ModelMapper modelMapper;

	@PostMapping("/product/{categoryId}")
	public ResponseEntity<ProductDto> addProduct(@RequestBody Product product, @PathVariable Long categoryId) {

		ProductDto productDto = productService.addProduct(product, categoryId);

		return new ResponseEntity<>(productDto, HttpStatus.CREATED);

	}

	/*
	 * getting all the products
	 */
	@GetMapping("/products")

	public ResponseEntity<ProductResponse> productResponse() {

		ProductResponse productResponse = productService.getAllProduct();

		return new ResponseEntity<>(productResponse, HttpStatus.OK);

	}
	
	/*
	 * getting product using categoryid 
	 */

	@GetMapping("/products/{categoryId}")
	
	public ResponseEntity<List<Product>> gettingProductUsingCategoryId(@PathVariable Long categoryId){
		
	List<Product> products=productService.findProductsByCategoryId(categoryId);
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
}
