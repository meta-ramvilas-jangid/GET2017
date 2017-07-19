import static org.junit.Assert.*;

import org.junit.Test;

public class LinearSearchTest {

	@Test
	public void testLinearSearch() {
		LinearSearch l=new LinearSearch();
		int arr[]={2,5,8,9,10,77,55};
		int actual=l.linearSearch(arr, 0, 88);
		assertEquals(-1, actual);		
	}
	@Test
	public void testLinearSearch1() {
		LinearSearch l=new LinearSearch();
		int arr[]={2,5,8,9,10,77,55};
		int actual=l.linearSearch(arr, 0, 77);
		assertEquals(5, actual);		
	}
	@Test
	public void testLinearSearch2() {
		LinearSearch l=new LinearSearch();
		int arr[]={1,6,7,9,3,2,10,1,6};
		int actual=l.linearSearch(arr, 0, 8);
		assertEquals(-1, actual);		
	}
	@Test
	public void testLinearSearch3() {
		LinearSearch l=new LinearSearch();
		int arr[]={};
		int actual=l.linearSearch(arr, 0, 0);
		assertEquals(-1, actual);		
	}

}
