package com.metacube.shoppingCart.TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.shoppingCart.controller.CartController;

public class CartControllerTest {

	@Test
	public void test1() {
		CartController.getInstance().addProductToCart(1001, 2);
		boolean actual = CartController.getInstance().isCartEmpty();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		boolean actual = CartController.getInstance().isProductPresentInCart(
				1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		boolean actual = CartController.getInstance().isProductPresentInCart(
				1002);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		CartController.getInstance().removeProductFromCart(1001);
		boolean actual = CartController.getInstance().isCartEmpty();
		boolean expected = true;
		assertEquals(expected, actual);
	}
}
