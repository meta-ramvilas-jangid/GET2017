package assignmentOopDay7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProductLevelPromotions implements Promotions {
	List<ProductLevelPromotions> productLevel;
	boolean amountType = false;
	boolean percentageType = false;
	double discount = 0.0;
	public List<String> productIdApplicable = null;
	
	public ProductLevelPromotions() throws IOException {

		productLevel = new ArrayList<ProductLevelPromotions>();
		FileReader productPromoFile = null;
		BufferedReader readProductPromo = null;
		try{
			productPromoFile = new FileReader("ProductPromo.csv");
			readProductPromo = new BufferedReader(productPromoFile);
			String productPromoEntry = null;
			while((productPromoEntry = readProductPromo.readLine())!=null){
				productLevel.add(new ProductLevelPromotions(productPromoEntry));
			}
		}catch(IOException e){
			System.out.println("File Exception Occured");
		}finally{
			productPromoFile.close();
			readProductPromo.close();
		}
	}
	public ProductLevelPromotions(String promo){
		StringTokenizer promoEntryTokenizer = new StringTokenizer(promo,",");
		if(promoEntryTokenizer.hasMoreElements() && promoEntryTokenizer.nextToken().contains("FixedAmount")){
			amountType = true;
		}else{
			percentageType = true;
		}
		discount = Double.parseDouble(promoEntryTokenizer.nextToken());
		String pIds = promoEntryTokenizer.nextToken();
		StringTokenizer applicableProducts = new StringTokenizer(pIds,";");
		productIdApplicable = new ArrayList<String>();
		while(applicableProducts.hasMoreElements()){
			productIdApplicable.add(applicableProducts.nextToken());
		}
		
	}
	
	public void displayProductLevelPromo(){
		for(ProductLevelPromotions p :productLevel){
			if(p.amountType){
				System.out.println("type - fixedAmount");
			}else if(p.percentageType){
				System.out.println("type - fixedPercent");
			}
			System.out.println("Discount - "+p.discount);
			for(String s: p.productIdApplicable){
				System.out.println(s+"   ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	public static void main(String[] args) throws IOException{
		ProductLevelPromotions o= new ProductLevelPromotions();
		o.displayProductLevelPromo();
	}
	@Override
	public boolean isApplicable(String productId) {
		if(productIdApplicable.contains(productId)){
			return true;
		}
		return false;
	}

	@Override
	public double getDiscount(double amount, double discount) {
		if(amountType){
			return discount;
		}else if(percentageType){
			return (amount*discount) / 100;
		}
		return 0;
	}
}
