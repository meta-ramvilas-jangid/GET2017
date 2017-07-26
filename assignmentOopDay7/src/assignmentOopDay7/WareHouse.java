package assignmentOopDay7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WareHouse {
	private List<Product> availableProducts;
	
	public List<Product> getAvailableProducts() {
		return availableProducts;
	}
	public WareHouse() throws IOException{
		availableProducts = new ArrayList<Product>();
		FileReader productFile = null;
		BufferedReader readProduct = null;
		try{
			productFile = new FileReader("ProductList.csv");
			readProduct = new BufferedReader(productFile);
			String productEntry = null;
			while((productEntry = readProduct.readLine())!=null){
				availableProducts.add(new Product(productEntry));
			}
		}catch(IOException e){
			System.out.println("File Exception Occured");
		}finally{
			productFile.close();
			readProduct.close();
		}
	}
	public Product getProductById(String idNumber){
		Product prod = null;
		for(Product p: availableProducts){
			if(idNumber.equals(p.getId())){
				prod = p;
				break;
			}
		}
		return prod;
	}
	public void displayProducts(){
		for(Product p : availableProducts){
			p.displayProduct();
		}
	}
	public static void main(String[] args) throws IOException{
		WareHouse w= new WareHouse();
		w.displayProducts();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id");
		String z=sc.nextLine();
	
		Product p=w.getProductById(z);
		
		p.displayProduct();
		
		}

}
