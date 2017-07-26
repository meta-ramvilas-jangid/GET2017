package assignmentOopDay7;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShoppingStoreTerminal {
	static Map<Product, Integer> orderMap;

	public static void main(String[] args) throws IOException {
		WareHouse w = new WareHouse();
		w.displayProducts();
		ProductLevelPromotions productPromos = new ProductLevelPromotions();
		productPromos.displayProductLevelPromo();
		OrderLevelPromotions orderPromo = new OrderLevelPromotions();
		orderPromo.displayOrderLevelPromo();
		Order order = new Order();
		System.out.println("how many products to buy");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int quantity = sc.nextInt();
		String productId;
		int enteredQuantity;

		while (quantity > 0) {
			System.out.println("enter product code from available products");
			productId = sc.next();
			if (w.getProductById(productId) == null) {
				System.out.println("Product Id doesn't exist pls retype ");
				continue;
			}
			System.out.println("Quantity :");
			enteredQuantity = sc.nextInt();

			if (enteredQuantity > quantity) {
				System.out.println("invalid quantity ,retype quantity");
				continue;
			}
			order.addProduct(w.getProductById(productId), enteredQuantity);
			quantity = quantity - enteredQuantity;

		}

		System.out.println("///////////////");
		
		order.displayOrder();

		/////////////////////////////////////////////////////////////////////////////
	

		//////////////////////////////////////////////////////////////////////////////
		
		System.out.println("APPLIED PROMOTIONS/DISCOUNTS :");
	
		orderMap = order.getOrderMap();
		@SuppressWarnings("unused")
		double totalProductDiscount = 0;
		double totalAmount = 0;
		double prductLevelDiscount=0;
		Set<Product> products = orderMap.keySet();
		for (Product pro : products){
			System.out.print("Promotion : ");
			double productDiscount = 0;
			for (ProductLevelPromotions p : productPromos.productLevel){
					double amount = 0;
					
						
				
						if (p.isApplicable(pro.getId())) {
							amount = pro.getPrice();
							productDiscount = p.getDiscount(amount, p.discount);
							amount = amount * orderMap.get(pro);
							productDiscount = productDiscount * orderMap.get(pro);
							System.out.println(productDiscount+" off on"+pro.getName()+" [Code:"+pro.getId()+"]");
							amount = amount - productDiscount;
							System.out.println("Discount : "+productDiscount);
							prductLevelDiscount+=productDiscount;
						}
					totalAmount += amount;
				
				//	System.out.println("--------------------------- amount : "+totalAmount);
				}
				//System.out.println("Discount : "+productDiscount);
		}
		System.out.println("\n\nprductLevelDiscount "+prductLevelDiscount);
		System.out.println("\n\n\ntotal Amout : " + totalAmount);
		
		//////////////////////////////////////////////////////////////////
		double maxDiscount = 0;
		for (OrderLevelPromotions o : orderPromo.orderLevel) {
			double discount = 0;
			if (o.isApplicable(totalAmount + "") && totalAmount >= o.discountOnAmount) {
				discount = o.getDiscount(totalAmount, o.discount);
				if (discount > maxDiscount) {
					maxDiscount = discount;
				}
			}
		}
		System.out.println("order Level Discount : " + maxDiscount);

		totalAmount -= maxDiscount;
		System.out.println("FinalAmount : " + totalAmount);

	}

}
