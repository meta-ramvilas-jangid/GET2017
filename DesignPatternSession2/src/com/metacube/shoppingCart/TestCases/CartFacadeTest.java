package com.metacube.shoppingCart.TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.shoppingCart.Facade.CartFacade;

public class CartFacadeTest {

	@Test
	public void test1() {
		CartFacade.getInstance().resetCart();
		boolean actual = CartFacade.getInstance().isCartEmpty();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		CartFacade.getInstance().addProductToCartByProductId(1001, 2);
		boolean actual = CartFacade.getInstance().isCartEmpty();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		boolean actual = CartFacade.getInstance().isProductPresentInCart(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		boolean actual = CartFacade.getInstance().isProductPresentInCart(1002);
		boolean expected = false;
		assertEquals(expected, actual);
	}
}
