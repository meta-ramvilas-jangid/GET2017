package assignmentOopDay7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ProductLevelPromotions implements Promotions {
	private List<ProductLevelPromotions> productLevel;
	private boolean amountType = false;
	private boolean percentageType = false;
	private double discount = 0.0;
	public List<String> productIdApplicable = null;
	/**
	 * constructor to initialize a list of promotions
	 */
	public ProductLevelPromotions() throws IOException {
		productLevel = new ArrayList<ProductLevelPromotions>();
		FileReader productPromoFile = null;
		BufferedReader readProductPromo = null;
		try {
			productPromoFile = new FileReader("ProductPromo.csv");
			readProductPromo = new BufferedReader(productPromoFile);
			String productPromoEntry = null;
			while ((productPromoEntry = readProductPromo.readLine()) != null) {
				productLevel.add(new ProductLevelPromotions(productPromoEntry));
			}
		} catch (IOException e) {
			System.out.println("File Exception Occured");
		} finally {
			productPromoFile.close();
			readProductPromo.close();
		}
	}
	/**
	 * constructor to initialize a single promo
	 */
	public ProductLevelPromotions(String promo) {
		StringTokenizer promoEntryTokenizer = new StringTokenizer(promo, ",");
		if (promoEntryTokenizer.hasMoreElements() && promoEntryTokenizer.nextToken().contains("FixedAmount")) {
			amountType = true;
		} else {
			percentageType = true;
		}
		discount = Double.parseDouble(promoEntryTokenizer.nextToken());
		String pIds = promoEntryTokenizer.nextToken();
		StringTokenizer applicableProducts = new StringTokenizer(pIds, ";");
		productIdApplicable = new ArrayList<String>();
		while (applicableProducts.hasMoreElements()) {
			productIdApplicable.add(applicableProducts.nextToken());
		}
	}
	/**
	 * display all promo codes valid
	 */
	public void displayProductLevelPromo() {
		System.out.println();
		System.out.println("product level promotions");
		System.out.println("######################################");
		System.out.println("type\t\tdiscount\tapplicable products");
		String discount = null;
		for (ProductLevelPromotions p : productLevel) {
			discount = "";
			discount = discount + p.discount;
			if (p.amountType) {
				System.out.print("fixedAmount\t");
				discount = "Rs " + discount;
			} else if (p.percentageType) {
				System.out.print("fixedPercent\t");
				discount += " %\t";
			}
			System.out.print(discount + "\t");
			for (String s : p.productIdApplicable) {
				System.out.print(s + "   ");
			}
			System.out.println();
		}
	}

	@Override
	public boolean isApplicable(String productId) {
		if (productIdApplicable.contains(productId)) {
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
	 * method to get total product discount and display on the console
	 */
	public double getTotalProductDiscount(Map<Product, Integer> orderMap) {
		double totalProductDiscount = 0;
		double maxProductDiscount = 0;
		// double totalAmount = 0;
		double amount = 0;
		double totalDiscount = 0;
		Set<Product> products = orderMap.keySet();

		System.out.println("");
		for (Product pro : products) {
			int orderedQuantity = orderMap.get(pro);
			amount = pro.getPrice();
			maxProductDiscount = 0;
			String discountType = "Rs 0";
			for (ProductLevelPromotions p : productLevel) {
				if (p.isApplicable(pro.getId())) {
					discountType = "";
					totalProductDiscount = p.getDiscount(amount, p.discount);
					totalProductDiscount *= orderedQuantity;
					// amount *= orderedQuantity;
					if (totalProductDiscount > maxProductDiscount) {
						maxProductDiscount = totalProductDiscount;
						if (p.amountType) {
							discountType = "Rs " + p.discount;
						} else {
							discountType = p.discount + "%";
						}
					}
				}
			}
			totalDiscount += maxProductDiscount;
			System.out.print("Promotions Applied : ");
			System.out.println(discountType + " off on " + pro.getName() + " [Code:" + pro.getId() + "]");
			System.out.println("quantity " + orderMap.get(pro));
			System.out.println("Discount Rs" + maxProductDiscount);
		}
		return totalDiscount;
	}
}
