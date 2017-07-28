import java.util.Scanner;

public class ActionableMenuItem extends MenuItem implements Action {
	// private Action action;
	public ActionableMenuItem(String name, Menu parent) {
		setName(name);
		setParent(parent);
	}
	
	@Override
	public void performAction() {
		String Action = this.getName();
		Matrix matrixA, matrixB;
		Matrix m = new Matrix();
		switch (Action) {
			case "Back":                        this.getParent().getParent().displayMenuAndAsk();
				                             		break;
			case "transpose of matrix":         matrixA = m.readMatrix();
				                                Matrix transposeA = matrixA.transpose();
				                                transposeA.show();
				                             		break;
			case "addition of two matrices":    matrixA = m.readMatrix();
				                                matrixB = m.readMatrix();
				                                Matrix matrixAdd = matrixA.addWith(matrixB);
				                                if(matrixAdd!=null){
				                                	matrixAdd.show();
				                                }
				                             		break;
			case "subtraction of two matrices": matrixA = m.readMatrix();
												matrixB = m.readMatrix();
												Matrix matrixSub = matrixA.subWith(matrixB);
												if(matrixSub!=null){
				                                	matrixSub.show();
				                                }
													break;
			case "multiplication of two matrices":       matrixA = m.readMatrix();
				                                matrixB = m.readMatrix();
				                                Matrix matrixC = matrixA.multiplyWith(matrixB);
				                                if(matrixC!=null){
				                                	matrixC.show();
				                                }
				                               		break;
			case "Exit":					    System.out.println("exiting the system");
												System.out.println("#########################################");
												System.exit(0);
			default:                            System.out.println("Action not supported");
													break;
		}
	}
}
