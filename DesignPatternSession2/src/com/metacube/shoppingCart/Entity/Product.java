package com.metacube.shoppingCart.Entity;

public class Product implements BaseEntity {
	private int productId;
	private String productName;
	private double productPrice;
	private String type;

	public Product(String[] details) {
		productId = Integer.parseInt(details[0]);
		productName = details[1];
		productPrice = Double.parseDouble(details[2]);
		type = details[3];
	}

	public int getId() {
		return productId;
	}

	public void setId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
