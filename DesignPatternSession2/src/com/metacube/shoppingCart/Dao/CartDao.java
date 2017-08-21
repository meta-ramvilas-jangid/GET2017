package com.metacube.shoppingCart.Dao;

import com.metacube.shoppingCart.Entity.CartProduct;

public interface CartDao extends BaseDao<CartProduct> {

	/**
	 * Reset Product quantity in cart
	 * @param productId
	 * @param quantity - product quantity
	 */
	public void editProductQuantity(int productId, int quantity);
}
