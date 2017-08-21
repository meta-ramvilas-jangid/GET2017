package com.metacube.shoppingCart.TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.shoppingCart.controller.StoreController;

public class StoreControllerTest {

	@Test
	public void test1() {
		boolean actual = StoreController.getInstance()
				.isValidNumberOfProduct(3);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		boolean actual = StoreController.getInstance().isValidNumberOfProduct(
				10);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		boolean actual = StoreController.getInstance().isValidProductId(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		boolean actual = StoreController.getInstance().isValidProductId(1004);
		boolean expected = false;
		assertEquals(expected, actual);
	}

}
