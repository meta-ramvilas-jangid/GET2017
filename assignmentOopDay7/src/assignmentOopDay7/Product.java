package assignmentOopDay7;

import java.util.StringTokenizer;

public class Product {
	private String id;
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
	private String name;
	private double price;
	public Product(String productEntry){
		StringTokenizer productEntryTokenizer = new StringTokenizer(productEntry,",");
		id = productEntryTokenizer.nextToken();
		name = productEntryTokenizer.nextToken();
		price = Double.parseDouble(productEntryTokenizer.nextToken());
	}
	
	public void displayProduct(){
		System.out.print("id "+id);
		System.out.print("   name "+name);
		System.out.println("   price "+price);
	}
}
