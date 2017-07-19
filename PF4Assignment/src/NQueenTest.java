import static org.junit.Assert.*;

import org.junit.Test;
public class NQueenTest{
    @Test
	public void testSolveNQueensUtil1(){
		NQueen n=new NQueen(1);
		int board[][]=new int[1][1];
		boolean b=n.solveNQueensUtil(board,0,1);
		assertEquals(true, b);
	}
	@Test
	public void testSolveNQueensUtil2() {
		NQueen n=new NQueen(2);
		int board[][]=new int[2][2];
		boolean b=n.solveNQueensUtil(board,0,2);
		assertEquals(false, b);
	}
	@Test
	public void testSolveNQueensUtil3() {
		NQueen n=new NQueen(3);
		int board[][]=new int[3][3];
		boolean b=n.solveNQueensUtil(board,0,3);
		assertEquals(false, b);
	}
	@Test
	public void testSolveNQueensUtil4() {
		NQueen n=new NQueen(4);
		int board[][]=new int[4][4];
		boolean b=n.solveNQueensUtil(board,0,4);
		assertEquals(true, b);
	}
	@Test
	public void testSolveNQueensUtil5() {
		NQueen n=new NQueen(5);
		int board[][]=new int[5][5];
		boolean b=n.solveNQueensUtil(board,0,5);
		assertEquals(true, b);
	}
	@Test
	public void testSolveNQueensUtil6() {
		NQueen n=new NQueen(6);
		int board[][]=new int[6][6];
		boolean b=n.solveNQueensUtil(board,0,6);
		assertEquals(true, b);
	}
	@Test
	public void testSolveNQueensUtil7() {
		NQueen n=new NQueen(7);
		int board[][]=new int[7][7];
		boolean b=n.solveNQueensUtil(board,0,7);
		assertEquals(true, b);
	}
	@Test
	public void testSolveNQueensUtil8() {
		NQueen n=new NQueen(8);
		int board[][]=new int[8][8];
		boolean b=n.solveNQueensUtil(board,0,8);
		assertEquals(true, b);
	}
}
