package com.metacube.shoppingCart.TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.shoppingCart.Facade.StoreFacade;

public class StoreFacadeTest {

	@Test
	public void test1() {
		boolean actual = StoreFacade.getInstance().isValidProductId(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		boolean actual = StoreFacade.getInstance().isValidProductId(1004);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		int actual = StoreFacade.getInstance().getTotalNoOfProductInStore();
		int expected = 3;
		assertEquals(expected, actual);
	}

}
