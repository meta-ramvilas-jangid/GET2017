package assignmentOopDay7;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Order {
	private Map<Product, Integer> orderMap;
	/**
	 * to get the order map
	 */
	public Map<Product, Integer> getOrderMap() {
		return orderMap;
	}
	/**
	 * constructor that initializes map
	 */
	public Order() {
		orderMap = new LinkedHashMap<Product, Integer>();
	}
	/**
	 * method to add products to order map
	 */
	public void addProduct(Product product, int quantity) {
		if (orderMap.containsKey(product)) {
			int value = orderMap.get(product);
			quantity = quantity + value;
		}
		orderMap.put(product, quantity);
	}
	/**
	 * display order
	 */
	// #######################################
	// order details
	// #######################################
	public void displayOrder() {
		System.out.println("#####################################################");
		System.out.println("YOUR ORDER :");
		System.out.println("#####################################################");
		System.out.println("PURCHASED PRODUCTS :");
		Set<Product> productKeys = orderMap.keySet();
		for (Product p : productKeys) {
			double amount = p.getPrice() * orderMap.get(p);
			System.out.println("Product :  " + p.getId() + " - " + p.getName());
			System.out.println("Cost : Rs" + amount + "(" + orderMap.get(p) + " x Rs" + p.getPrice() + ")");
			System.out.println();
		}
	}
	/**
	 * method to get order from user and validate
	 */
	public void askAndValidateOrder(WareHouse w) {
		boolean validNumber = false;
		boolean validQuantity = false;
		int quantity = 0;
		System.out.println("how many products to buy");
		while (!validNumber) {
			try {
				quantity = new Scanner(System.in).nextInt();
				if (quantity > 0) {
					validNumber = true;
				} else {
					System.out.println("no of products should be greater than zero");
				}
			} catch (InputMismatchException e) {
				System.out.println("not a number!! try again");
			}
		}
		int enteredQuantity = 0;
		String productId;
		while (quantity > 0) {
			System.out.println("enter product code from available products");
			productId = new Scanner(System.in).next();
			if (w.getProductById(productId) == null) {
				System.out.println("Product Id doesn't exist pls retype ");
				continue;
			}
			System.out.println("Quantity :");
			while (!validQuantity) {
				try {
					enteredQuantity = new Scanner(System.in).nextInt();
					if (enteredQuantity > 0) {
						validQuantity = true;
					} else {
						System.out.println("quantity should be greater than zero");
					}
				} catch (NumberFormatException e) {
					System.out.println("not a number!! try again");
				}
			}
			if (enteredQuantity > quantity) {
				System.out.println("You can now buy a max of " + quantity + " products");
				continue;
			}
			addProduct(w.getProductById(productId), enteredQuantity);
			quantity = quantity - enteredQuantity;
			validQuantity = false;
		}
	}
	/**
	 * mthod to get total order amount
	 */
	public double getTotalAmount() {
		double totalAmount = 0;
		int number = 0;
		Set<Product> setOfProducts = orderMap.keySet();
		for (Product p : setOfProducts) {
			number = orderMap.get(p);
			totalAmount += p.getPrice() * number;
		}
		return totalAmount;
	}
}
