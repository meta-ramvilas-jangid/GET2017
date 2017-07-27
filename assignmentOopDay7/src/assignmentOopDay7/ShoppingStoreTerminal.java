package assignmentOopDay7;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class ShoppingStoreTerminal {
	private Map<Product, Integer> orderMap; // to retain the map of orders
	private double totalAmount; // total amount for order
	private double totalProductDiscount; // total discount for order
	private double netProductAmount; // total product discount
	private double totalOrderDiscount; // total order discount

	/**
	 * constructor
	 */
	public ShoppingStoreTerminal() {
		totalAmount = 0;
		totalProductDiscount = 0;
		netProductAmount = 0;
		totalOrderDiscount = 0;
	}
	/**
	 * to print the final bill
	 */
	public void printFinalReceipt() {
		double finalAmount = 0;
		double finalDiscount = 0;
		DecimalFormat decimaFormat = new DecimalFormat("00.00");
		System.out.println("#######################################");
		System.out.println("Sub Total Rs" + totalAmount);
		System.out.println("Product Discount Total Rs" + totalProductDiscount);
		System.out.println("Order Discount Total Rs" + totalOrderDiscount);
		finalDiscount = totalProductDiscount + totalOrderDiscount;
		System.out.println("Total Discounts Rs" + decimaFormat.format(finalDiscount));
		finalAmount = totalAmount - finalDiscount;
		System.out.println("Total: Rs" + decimaFormat.format(finalAmount));
	}
	/**
	 * main method initializes warehouse then product promos the order promos
	 * initializes order ask the user for input calculates discount print
	 * receipt
	 */
	public static void main(String[] args) throws IOException {
		ShoppingStoreTerminal sst = new ShoppingStoreTerminal();
		WareHouse w = new WareHouse();
		w.displayProducts();
		ProductLevelPromotions productPromos = new ProductLevelPromotions();
		productPromos.displayProductLevelPromo();
		OrderLevelPromotions orderPromo = new OrderLevelPromotions();
		orderPromo.displayOrderLevelPromo();
		Order order = new Order();
		order.askAndValidateOrder(w);
		order.displayOrder();

		sst.totalAmount = order.getTotalAmount();
		sst.orderMap = order.getOrderMap();
		sst.totalProductDiscount = productPromos.getTotalProductDiscount(sst.orderMap);
		System.out.println();
		sst.netProductAmount = sst.totalAmount - sst.totalProductDiscount;
		sst.totalOrderDiscount = orderPromo.getTotalOrderDiscount(sst.netProductAmount);
		sst.printFinalReceipt();
	}
}
