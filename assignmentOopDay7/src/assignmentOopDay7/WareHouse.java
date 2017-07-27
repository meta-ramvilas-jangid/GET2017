package assignmentOopDay7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WareHouse {
	private List<Product> availableProducts;			//warehouse contains a list of products
	/**
	 *method to get the list of products
	 */
	public List<Product> getAvailableProducts() {
		return availableProducts;
	}
	/**
	 *constructor
	 * initializes the list of products
	 * after reading from file
	 */
	public WareHouse() throws IOException {
		availableProducts = new ArrayList<Product>();
		FileReader productFile = null;
		BufferedReader readProduct = null;
		try {
			productFile = new FileReader("ProductList.csv");
			readProduct = new BufferedReader(productFile);
			String productEntry = null;
			while ((productEntry = readProduct.readLine()) != null) {
				availableProducts.add(new Product(productEntry));
			}
		} catch (IOException e) {
			System.out.println("File Exception Occured");
		} finally {
			productFile.close();
			readProduct.close();
		}
	}
	/**
	 *method to retrieve
	 * product from warehouse 
	 * by its id
	 */
	public Product getProductById(String idNumber) {
		Product prod = null;
		for (Product p : availableProducts) {
			if (idNumber.equals(p.getId())) {
				prod = p;
				break;
			}
		}
		return prod;
	}
	/**
	 *method to display
	 * products in 
	 * warehouse
	 */
	public void displayProducts() {
		for (Product p : availableProducts) {
			p.displayProduct();
		}
	}
}
