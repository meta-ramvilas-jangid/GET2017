import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void test1() {
		int[] arr = { 2, 3, 7, 9, 10, 12, 12, 12, 12, 12, 12, 13 };
		BinarySearch b=new BinarySearch();
		int actual = b.binarySearch(arr, 0, arr.length-1, 12);
		int expected = 5;
		assertEquals(expected, actual);
	}

	/*
	 * all elements same in array
	 */
	@Test
	public void test2() {
		int[] arr = { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 };
		BinarySearch b=new BinarySearch();
		int actual = b.binarySearch(arr, 0, arr.length-1, 7);
		int expected = 0;
		assertEquals(expected, actual);
	}

	/*
	 * single element in array
	 */
	@Test
	public void test3() {
		int[] arr = { 2 };
		BinarySearch b=new BinarySearch();
		int actual = b.binarySearch(arr, 0, arr.length-1, 2);
		int expected = 0;
		assertEquals(expected, actual);
	}

	/*
	 * test exceptional case
	 */
	public void test4() {
		int[] arr = {};
		BinarySearch b=new BinarySearch();
		@SuppressWarnings("unused")
		int actual = b.binarySearch(arr, 0, arr.length-1, 12);
		int expected =-1;
		assertEquals(expected, actual);
	}



	/*
	 * false test
	 */
	@Test
	public void test6() {
		int[] arr = { 2, 3, 7, 9, 10, 10, 10, 10, 12, 12, 12, 13 };
		BinarySearch b=new BinarySearch();
		int actual = b.binarySearch(arr, 0, arr.length-1, 10);
		int expected = 2; // expected= 4
		assertNotEquals(expected, actual);
	}


}
