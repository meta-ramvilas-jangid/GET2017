public class MainClass {

	public static void main(String[] args) {
		Menu root = new Menu("root menu", null);
		
		Menu Item1 = new Menu("Do Operations",root);
		ActionableMenuItem Item2 = new ActionableMenuItem("Exit",root);
		
		Menu operationItem1 = new Menu("opeartion on a single matrix", Item1);
		Menu operationItem2 = new Menu("opeartion on two matrices", Item1);
		ActionableMenuItem operationItem3 = new ActionableMenuItem("Back",Item1);

		MenuItem singleOperationItem1 = new ActionableMenuItem("transpose of matrix", operationItem1);
		ActionableMenuItem singleOperationItem2 = new ActionableMenuItem("Back",operationItem1);

		MenuItem doubleOperationItem1 = new ActionableMenuItem("addition of two matrices", operationItem2);
		MenuItem doubleOperationItem2 = new ActionableMenuItem("subtraction of two matrices", operationItem2);
		MenuItem doubleOperationItem3 = new ActionableMenuItem("multiplication of two matrices", operationItem2);
		ActionableMenuItem doubleOperationItem4 = new ActionableMenuItem("Back",operationItem2);
		
		root.add(Item1);
		root.add(Item2);
		Item1.add(operationItem1);
		Item1.add(operationItem2);
		Item1.add(operationItem3);
		Item1.add(Item2);
		operationItem1.add(singleOperationItem1);
		operationItem1.add(singleOperationItem2);
		operationItem1.add(Item2);
		operationItem2.add(doubleOperationItem1);
		operationItem2.add(doubleOperationItem2);
		operationItem2.add(doubleOperationItem3);
		operationItem2.add(doubleOperationItem4);
		operationItem2.add(Item2);
		
		root.displayMenuAndAsk();
	}

}
