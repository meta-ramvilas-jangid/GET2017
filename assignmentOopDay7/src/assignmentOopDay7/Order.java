package assignmentOopDay7;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Order {
	private Map<Product, Integer> orderMap;
	
	public Map<Product, Integer> getOrderMap() {
		return orderMap;
	}
	public Order(){
		orderMap = new LinkedHashMap<Product, Integer>();
	}
	public void addProduct(Product product, int quantity){
		if(orderMap.containsKey(product)){
			int value=orderMap.get(product);
			quantity=quantity+value;
		}
		orderMap.put(product, quantity);
	}
	
	public void displayOrder(){
		System.out.println("#####################################################");
		System.out.println("YOUR ORDER :");
		System.out.println("#####################################################");
		System.out.println("PURCHASED PRODUCTS :");
		Set<Product> productKeys = orderMap.keySet();
		for(Product p: productKeys){
			double amount=p.getPrice()*orderMap.get(p);
			System.out.println("Product :  "+p.getId()+" - "+p.getName());
			System.out.println("Cost : Rs"+amount+"("+orderMap.get(p)+" x Rs"+p.getPrice()+")");
			System.out.println();
		}
		//	p.displayProduct();
			//System.out.println(orderMap.get(p));
		}
	}


