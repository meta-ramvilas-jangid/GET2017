package com.metacube.shoppingCart.Entity;

public class CartProduct extends Product {

	private int quantity;

	public CartProduct(String[] productDetails) {
		super(productDetails);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
