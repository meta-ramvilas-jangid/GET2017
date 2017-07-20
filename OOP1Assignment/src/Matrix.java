import java.security.InvalidParameterException;

public class Matrix {

	private final int row;
	private final int col;
	public double mat[][];

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

	public void addElements(int row, int col, int value) {
		mat[row][col] = value;
	}

	public String show() {
		String str = "";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				str = str + mat[i][j] + " ";
			}
			str = str + "\n";
		}
		return str;
	}

	public Matrix transpose() {
		Matrix mat2 = new Matrix(col, row);
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				mat2.mat[i][j] = mat[j][i];
			}
		}
		return mat2;
	}

	public Matrix multiplyWith(Matrix matrixB) {
		if (this.col != matrixB.row) {
			throw new InvalidParameterException("column size of matrix A should be equal to row size of matrix B");
		}
		Matrix matrixC = new Matrix(this.row, matrixB.col);
		for (int rowIndexC = 0; rowIndexC < matrixC.row; rowIndexC++) {
			for (int colIndexC = 0; colIndexC < matrixC.col; colIndexC++) {
				for (int index = 0; index < matrixB.row; index++) {
					matrixC.mat[rowIndexC][colIndexC] += this.mat[rowIndexC][index]
							* matrixB.mat[index][colIndexC];
				}
			}
		}
		return matrixC;
	}

	public static void main(String[] args) {
        double arr[][] = { { 1, 2 }, { 3, 2 }, { 1, 1 } };
		Matrix mat1 = new Matrix(arr);
		String str = mat1.show();
		System.out.println(str);

		Matrix mat2 = mat1.transpose();
        String str1 = mat2.show();
		System.out.println(str1);
		
		//Matrix mat3=m2.
	}
}
