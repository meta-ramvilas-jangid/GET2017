package assignmentOopDay7;

import java.util.StringTokenizer;

public class Product {
	private String id;
	private String name;
	/**
	 * getters and setters
	 */
	private double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * constructor to initialize product for every line read from file
	 */
	public Product(String productEntry) {
		StringTokenizer productEntryTokenizer = new StringTokenizer(productEntry, ",");
		id = productEntryTokenizer.nextToken();
		name = productEntryTokenizer.nextToken();
		price = Double.parseDouble(productEntryTokenizer.nextToken());
	}
	/**
	 * method to display a product
	 */
	public void displayProduct() {
		System.out.println("product id\t\tproduct name\t\t\t\tproduct price");
		System.out.println(id + "\t\t\t" + name + "\t\t\t\t" + price);
	}
}
