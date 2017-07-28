import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends MenuItem{
	private List<MenuItem> menuItemList;
	
	public Menu(String name, Menu parent) {
		setName(name);
		setParent(parent);
		menuItemList = new ArrayList<MenuItem>();
	}


	public void add(MenuItem subMenuItem ){
		menuItemList.add(subMenuItem);
	}
	
	public void displayMenuAndAsk(){
		boolean validChoice =false;
		int choice = 0;
		int choiceIndex = 1;
		int size = menuItemList.size();
		System.out.println(this.getName()+"'s Menu");
		System.out.println("#########################################");
		for(MenuItem mi: menuItemList){
			System.out.println(choiceIndex+" "+mi.getName());
			choiceIndex ++;
		}
		System.out.println();
		System.out.print("Enter your choice: ");
		Scanner scanInput=new Scanner(System.in);
		do{
			try{
			choice = new Scanner(System.in).nextInt();
			if(choice > 0 && choice <= size){
				validChoice=true;
			}else{
				System.out.println("choose from required options\nenter again");
			}
			}catch(IllegalArgumentException e){
				System.out.println("choice must be a number");
			}
		}while(!validChoice);
		
		doAction(choice);
		scanInput.close();
	}
	
	public void doAction(int choice){
		MenuItem selected = menuItemList.get(choice-1);
		if(selected instanceof ActionableMenuItem){
			((ActionableMenuItem) selected).performAction();
			displayMenuAndAsk();
		}else if(selected instanceof Menu){
			((Menu) selected).displayMenuAndAsk();
		}
		
	}
	
}
