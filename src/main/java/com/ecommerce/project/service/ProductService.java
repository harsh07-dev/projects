package com.ecommerce.project.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.project.controller.repository.CategoryRepository;
import com.ecommerce.project.controller.repository.ProductRepo;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.model.Product;
import com.ecommerce.project.myGlobalExceptionHnadler.ResourceNotFoundException;
import com.ecommerce.project.payloadDTO.ProductDto;
import com.ecommerce.project.payloadDTO.ProductResponse;

@Service
public class ProductService {
	
	@Autowired
	CategoryRepository categoryRepositoy;
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	public  ProductDto addProduct(Product product,Long catagoryId) {
		
		Category category=categoryRepositoy.findById(catagoryId)
				.orElseThrow( () -> 
				new ResourceNotFoundException("Category","categoryId",catagoryId) );
		
		         product.setCategory(category);
	// special price is the price that is calculated after the discount;	         
		double specialPrice=product.getPrice() -((product.getDiscount()/100) *100 );
		       product.setSpecialPrice(specialPrice);
		Product saveProduct =productRepo.save(product);
		
		ProductDto poductDto=modelMapper.map(saveProduct , ProductDto.class);
		
		poductDto.setImage("image is loaded");
		return poductDto;
		
		
	
		
		
		
		
	}

	public ProductResponse getAllProduct() {
		
		List<Product> products = productRepo.findAll();
        List<ProductDto> productDTOS = products.stream()
                .map(product ->modelMapper.map(product, ProductDto.class))
                .toList();
		ProductResponse productResponse=new ProductResponse();
		productResponse.setProductContent(productDTOS);
		
		return productResponse ;  
		
		
	}

	public List<Product> findProductsByCategoryId(Long categoryId) {
		
		Category category =categoryRepositoy.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		
		List<Product> products=productRepo.findProductByCustomerId(categoryId);
		System.out.println(products);
		return products;
		
		 
				
	}


}
