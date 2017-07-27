package assignmentOopDay7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OrderLevelPromotions implements Promotions {
	private List<OrderLevelPromotions> orderLevel;													
	private boolean amountType = false;																
	private boolean percentageType = false;															
	private double discount = 0.0;																	
	private double discountOnAmount = 0.0;
	/**
	 * constructor to initialize 
	 * a list of promotions
	 */
	public OrderLevelPromotions() throws IOException {

		orderLevel = new ArrayList<OrderLevelPromotions>();
		FileReader orderPromoFile = null;
		BufferedReader readOrderPromo = null;
		try {
			orderPromoFile = new FileReader("OrderPromo.csv");
			readOrderPromo = new BufferedReader(orderPromoFile);
			String orderPromoEntry = null;
			while ((orderPromoEntry = readOrderPromo.readLine()) != null) {
				orderLevel.add(new OrderLevelPromotions(orderPromoEntry));
			}
		} catch (IOException e) {
			System.out.println("File Exception Occured");
		} finally {
			orderPromoFile.close();
			readOrderPromo.close();
		}
	}
         /**
	 * constructor to initialize 
	 * a single promo
	 */
	public OrderLevelPromotions(String promo) {
		StringTokenizer promoEntryTokenizer = new StringTokenizer(promo, ",");
		if (promoEntryTokenizer.hasMoreElements()
				&& promoEntryTokenizer.nextToken().equals(
						"OrderFixedAmountPromotion")) {
			amountType = true;
		} else {
			percentageType = true;
		}
		discount = Double.parseDouble(promoEntryTokenizer.nextToken());
		discountOnAmount = Double.parseDouble(promoEntryTokenizer.nextToken());
	}
	/**
	 * display all promo codes valid
	 */
	public void displayOrderLevelPromo() {
		System.out.println();
		System.out.println("order level promotions");
		System.out.println("###################################");
		System.out.println("type\t\tdiscount\tabove order value");
		String discount = null;
		for (OrderLevelPromotions p : orderLevel) {
			discount = "";
			discount = discount + p.discount;
			if (p.amountType) {
				System.out.print("fixedAmount\t");
				discount = "Rs " + discount;
			} else if (p.percentageType) {
				System.out.print("fixedPercent\t");
				discount += " %\t";
			}
			System.out.print(discount + "\t\t");
			System.out.print(p.discountOnAmount);
			System.out.println();
		}
	}

	@Override
	public boolean isApplicable(String orderValue) {
		double value = Double.parseDouble(orderValue);
		if (value > discountOnAmount) {
			return true;
		}
		return false;
	}

	@Override
	public double getDiscount(double amount, double discount) {
		if (amountType) {
			return discount;
		} else if (percentageType) {
			return (amount * discount) / 100;
		}
		return 0;
	}
	/**
	 *method to get total product discount
	 * and display on the console
	 */
	public double getTotalOrderDiscount(double netProductAmount) {
		double maxOrderDiscount = 0;
		double totalOrderDiscount = 0;
		double maxApplicableDiscount = 0;
		String discountType = "Rs 0";
		for (OrderLevelPromotions o : orderLevel) {
			if (o.isApplicable(String.valueOf(netProductAmount))) {
				discountType = "";
				totalOrderDiscount = o
						.getDiscount(netProductAmount, o.discount);
				if (totalOrderDiscount > maxOrderDiscount) {
					if (o.amountType) {
						discountType = "Rs " + o.discount;
					} else {
						discountType = o.discount + "%";
					}
					maxOrderDiscount = totalOrderDiscount;
					maxApplicableDiscount = o.discountOnAmount;
				}
			}
		}
		System.out.print("Promotions Applied : ");
		System.out.println(discountType + " off on orders above "
				+ maxApplicableDiscount);
		// System.out.println("quantity "+orderMap.get(pro));
		System.out.println("Discount Rs" + maxOrderDiscount);
		return maxOrderDiscount;
	}
}
