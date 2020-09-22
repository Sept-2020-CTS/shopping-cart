package com.shopping.cart.model;

public class Product {

	private String productName;
	
	private int productPrice;
	
	private int productQty;
	
	private int productDescription;
	
	private String productImage;
	
	public Product() {}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public int getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(int productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
}
