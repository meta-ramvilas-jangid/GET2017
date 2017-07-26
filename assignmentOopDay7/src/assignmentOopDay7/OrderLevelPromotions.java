package assignmentOopDay7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class OrderLevelPromotions implements Promotions {
	List<OrderLevelPromotions> orderLevel;
	boolean amountType = false;
	boolean percentageType = false;
	double discount = 0.0;
	double discountOnAmount = 0.0;
	public OrderLevelPromotions() throws IOException {

		orderLevel = new ArrayList<OrderLevelPromotions>();
		FileReader orderPromoFile = null;
		BufferedReader readOrderPromo = null;
		try{
			orderPromoFile = new FileReader("OrderPromo.csv");
			readOrderPromo = new BufferedReader(orderPromoFile);
			String orderPromoEntry = null;
			while((orderPromoEntry = readOrderPromo.readLine())!=null){
				orderLevel.add(new OrderLevelPromotions(orderPromoEntry));
			}
		}catch(IOException e){
			System.out.println("File Exception Occured");
		}finally{
			orderPromoFile.close();
			readOrderPromo.close();
		}
	}
	public OrderLevelPromotions(String promo){
		StringTokenizer promoEntryTokenizer = new StringTokenizer(promo,",");
		if(promoEntryTokenizer.hasMoreElements() && promoEntryTokenizer.nextToken().equals("OrderFixedAmountPromotion")){
			amountType = true;
		}else{
			percentageType = true;
		}
		discount = Double.parseDouble(promoEntryTokenizer.nextToken());
		discountOnAmount = Double.parseDouble(promoEntryTokenizer.nextToken());
		
		
	}
	public void displayOrderLevelPromo(){
		for(OrderLevelPromotions p :orderLevel){
			if(p.amountType){
				System.out.println("type - fixedAmount");
			}else if(p.percentageType){
				System.out.println("type - fixedPercent");
			}
			System.out.println("Discount - "+p.discount);
			System.out.println("Discount on - "+p.discountOnAmount);
		}
	}
	@Override
	public boolean isApplicable(String productAmount) {
		// TODO Auto-generated method stub
		double value = Double.parseDouble(productAmount);
		if (value > discountOnAmount) {
			return true;
		}
		return false;
	
	}

	@Override
	public double getDiscount(double amount, double discount) {
		// TODO Auto-generated method stub
		if(percentageType){
			return (amount*discount)/100;
		}
		return discount;
	}

	public static void main(String[] args) throws IOException{
		OrderLevelPromotions o= new OrderLevelPromotions();
		o.displayOrderLevelPromo();
	}
}
