package com.metacube.shoppingCart.controller;

import com.metacube.shoppingCart.Facade.BillGeneratorFacade;
import com.metacube.shoppingCart.Facade.CartFacade;
import com.metacube.shoppingCart.View.DisplayOutput;

public class CartController {
	private static CartController cartController;
	public static CartController getInstance() {
		if (cartController == null) {
			synchronized (CartController.class) {
				if (cartController == null) {
					cartController = new CartController();
				}
			}
		}

		return cartController;
	}

	/**
	 * Display the details of Product present in Cart
	 */
	public void displayCart() {
		DisplayOutput.getInstance().displayOutput(CartFacade.getInstance());
	}

	public boolean isProductPresentInCart(int productId) {
		return CartFacade.getInstance().isProductPresentInCart(productId);
	}

	/** 
	 * @return true if Cart is Empty else false
	 */
	public boolean isCartEmpty() {
		return CartFacade.getInstance().isCartEmpty();
	}

	/**
	 * Add product to cart
	 * @param productId
	 * @param quantity - quantity of Product
	 */
	public void addProductToCart(int productId, int quantity) {
		DisplayOutput.getInstance().displayOutput(
				CartFacade.getInstance().addProductToCartByProductId(productId,
						quantity));
	}

	/**
	 * Remove product from cart by product Id
	 * @param productId
	 */
	public void removeProductFromCart(int productId) {
		DisplayOutput.getInstance().displayOutput(
				CartFacade.getInstance().removeProductFromCartByProductId(
						productId));
	}

	public void editProductFromCart(int productId, int quantity) {
		DisplayOutput.getInstance().displayOutput(
				CartFacade.getInstance().editCartProduct(productId, quantity));
	}

	/**
	 * Generate final bill
	 * @param name - Billing name
	 */
	public void generateBill(String name) {
		DisplayOutput.getInstance().displayOutput(
				BillGeneratorFacade.getInstance().getBill(name));
	}
}
