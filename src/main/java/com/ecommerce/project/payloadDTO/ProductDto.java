package com.ecommerce.project.payloadDTO;


public class ProductDto {
	
	private Long productId;
	private String productName;
	private String image;
	private Integer quantiy;
	private double price;
	private double discount;
	private double specialPrice;
	public ProductDto(Long productId, String productName, String image, Integer quantiy, double price, double discount,
			double specialPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.image = image;
		this.quantiy = quantiy;
		this.price = price;
		this.discount = discount;
		this.specialPrice = specialPrice;
	}
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(Integer quantiy) {
		this.quantiy = quantiy;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(double specialPrice) {
		this.specialPrice = specialPrice;
	}

}
