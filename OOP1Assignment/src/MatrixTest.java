import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixTest {
	
	// this test will check the multiplication of two square 
	@Test
	public void testMultiply() {
		double arr[][] = {{1, 2, 3},{3, 2, 1},{1, 1, 1}};
		Matrix matrixA = new Matrix(arr);
		double arr1[][] = {{3, 5},{5, 7},{4, 1}};
		Matrix matrixB = new Matrix(arr1);
		Matrix actualMatrix = matrixA.multiplyWith(matrixB);
		double arr2[][]={{25, 22},{23, 30},{12, 13}};
		Matrix expectedMatrix = new Matrix(arr2);
		assertArrayEquals(expectedMatrix.mat, actualMatrix.mat);
	}
    /* this test will check multiplication of two matrices with different rows
	    and columns*/
   @Test(expected = IllegalArgumentException.class)
   public void testMultiply2() {
	   	double arr[][] = {{1, 2, 3},{3, 2, 1},{1, 1, 1}};
		Matrix matrixA = new Matrix(arr);
		double arr1[][] = {{3, 5}, {5, 7},{4, 1},{2, 3}};
		Matrix matrixB = new Matrix(arr1);
		matrixA.multiplyWith(matrixB);
   }
   // this test will check the transpose of a matrix
   @Test
   public void testTranspose() {
	   double arr[][] = {{1, 2, 3},{3, 2, 1},{1, 1, 1}};
	   Matrix matrixA = new Matrix(arr);
	   double arr1[][] = {{1, 3, 1},{ 2, 2, 1},{3, 1, 1}};
	   Matrix expectedMatrix = new Matrix(arr1);
	   Matrix actualMatrix = matrixA.transpose();
	   assertArrayEquals(expectedMatrix.mat, actualMatrix.mat);
   }
}
