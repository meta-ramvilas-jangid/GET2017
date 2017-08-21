package com.metacube.shoppingCart.controller;

import com.metacube.shoppingCart.Facade.StoreFacade;
import com.metacube.shoppingCart.View.DisplayOutput;

public class StoreController {
	private static StoreController storeController;

	public static StoreController getInstance() {
		if (storeController == null) {
			synchronized (StoreController.class) {
				if (storeController == null) {
					storeController = new StoreController();
				}
			}
		}

		return storeController;
	}

	public void displayProduct() {
		DisplayOutput.getInstance().displayOutput(StoreFacade.getInstance());
	}

	/**
	 * @param productId
	 * @return true if product Id is valid else false;
	 */
	public boolean isValidProductId(int productId) {
		return StoreFacade.getInstance().isValidProductId(productId);
	}

	/**
	 * @param numberOfProduct - Number of Product
	 * @return true if input number is Valid else false
	 */
	public boolean isValidNumberOfProduct(int numberOfProduct) {
		boolean flag = false;
		if (StoreFacade.getInstance().getTotalNoOfProductInStore() >= numberOfProduct) {
			flag = true;
		}

		return flag;
	}
}
