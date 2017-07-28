import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {

	private  int row;
	private  int col;
	private double mat[][];


	public double[][] getMat() {
		return mat;
	}

	public void setMat(double[][] mat) {
		this.mat = mat;
	}


	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public Matrix() {
		row = 0;
		col = 0;
	}
	
	public Matrix(int row, int col) {
		this.row = row;
		this.col = col;
		mat = new double[row][col];
	}

	public Matrix(double[][] arr) {
		row = arr.length;
		col = arr[0].length;
		mat = new double[row][col];
		mat = arr;
	}

	public void addElements(int row, int col, double value) {
		mat[row][col] = value;
	}

	public void show() {
		String str = "";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				str = str + mat[i][j] + " ";
			}
			str = str + "\n";
			
		}
		System.out.print(str);
		
	}


	public Matrix readMatrix() {
		Matrix m=new Matrix();
		boolean validation = false;
		while (!validation) {
			try {
				int p, q;
				Scanner s = new Scanner(System.in);
				System.out.print("Enter number of rows in matrix:");
				m.row=s.nextInt();
				System.out.print("Enter number of columns in matrix:");
				m.col = s.nextInt();
				
				double a[][] = new double[m.row][m.col];
				
				System.out.println("Enter all the elements of matrix:");
				for (int i = 0; i < m.row; i++) {
					for (int j = 0; j < m.col; j++) {
						System.out.print("elements at cell [" + i + "," + j + "] : ");
						a[i][j] = s.nextDouble();
					}
				}
				m.setMat(a);
				validation = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input :");
				validation = false;
				continue;
			}
		}
     return m;
	}

	public Matrix multiplyWith(Matrix matrixB) {
		if (col != matrixB.row) {
			System.out.println("column size of matrix A should be equal to row size of matrix B");
			return null;
			
		}
		Matrix matrixC = new Matrix(row, matrixB.col);
		for (int rowIndexC = 0; rowIndexC < matrixC.row; rowIndexC++) {
			for (int colIndexC = 0; colIndexC < matrixC.col; colIndexC++) {
				for (int index = 0; index < matrixB.row; index++) {
					matrixC.mat[rowIndexC][colIndexC] += mat[rowIndexC][index]
							* matrixB.mat[index][colIndexC];
				}
			}
		}
		return matrixC;

	}

	public Matrix transpose() {

		Matrix matrixC = new Matrix(col, row);
		for (int rowIndexC = 0; rowIndexC < matrixC.row; rowIndexC++) {
			for (int colIndexC = 0; colIndexC < matrixC.col; colIndexC++) {
				matrixC.mat[rowIndexC][colIndexC] = mat[colIndexC][rowIndexC];
			}
		}
		return matrixC;

	}

//	public static void main(String[] args) {
//
//		double arr[][] = { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 1, 1 } };
//		Matrix matrixA = new Matrix(arr);
//		double arr1[][] = { { 3, 5 }, { 5, 7 }, { 4, 1 } };
//		Matrix matrixB = new Matrix(arr1);
//		Matrix matrixC = matrixA.multiplyWith(matrixB);
//		System.out.println(matrixC.show());
//		Matrix matrixD = matrixA.transpose();
//		//System.out.println(matrixD.show());
//	}

	public Matrix addWith(Matrix matrixB) {
		// TODO Auto-generated method stub
		try{
			if(row==matrixB.row && col==matrixB.col){
			Matrix m=new Matrix(row,col);
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					m.mat[i][j]=mat[i][j]+matrixB.mat[i][j];
				}
			}
			return m;
		}
		else{
			System.out.println("\n\nRow and Col mismatch can't be done this operation \n\n" );
		}
	}catch(NullPointerException e){
		System.out.println("\n\nRow and Col mismatch can't be done this operation\n\n");
	}
		return null;
	}

	public Matrix subWith(Matrix matrixB) {
		// TODO Auto-generated method stub
		try{
			if(row==matrixB.row && col==matrixB.col){
			Matrix m=new Matrix(row,col);
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					m.mat[i][j]=mat[i][j]-matrixB.mat[i][j];
				}
			}
			return m;
		}
		else{
			System.out.println("\n\nRow and Col mismatch can't be done this operation \n\n" );
		}
	}catch(NullPointerException e){
		System.out.println("\n\nRow and Col mismatch can't be done this operation\n\n");
	}
		return null;
	}

	

}
