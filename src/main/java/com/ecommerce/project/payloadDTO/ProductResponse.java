package com.ecommerce.project.payloadDTO;

import java.util.List;

public class ProductResponse {
	
	public List<ProductDto> productContent;

	public List<ProductDto> getProductContent() {
		return productContent;
	}

	public void setProductContent(List<ProductDto> productContent) {
		this.productContent = productContent;
	}

	public ProductResponse(List<ProductDto> productContent) {
		super();
		this.productContent = productContent;
	}

	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
	
	
}
