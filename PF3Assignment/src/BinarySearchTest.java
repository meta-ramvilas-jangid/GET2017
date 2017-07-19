import static org.junit.Assert.*;
import org.junit.Test;
public class BinarySearchTest {
	@Test
	public void testBinarySearch0() {
		BinarySearch b=new BinarySearch();
		int arr[]={1,6,7,9,13,21,23,31,36};
		int actual1=b.binarySearch(arr, 0, 8, 36);
	}
	@Test
	public void testBinarySearch1() {
		BinarySearch b=new BinarySearch();
		int arr[]={2,5,8,9,10,55,77};
		int actual1=b.binarySearch(arr, 0, 6, 88);
	}
	@Test
	public void testBinarySearch2() {
		BinarySearch b=new BinarySearch();
		int arr[]={2,5,8,9,10,77,55,11};
		int actual1=b.binarySearch(arr, 0, 7, 77);
	}
	@Test
	public void testBinarySearch3() {
		BinarySearch b=new BinarySearch();
		int arr[]={1,6,7,9,13,21,23,31,31};
		int actual1=b.binarySearch(arr, 0, 8, 31);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testBinarySearch4() {
		BinarySearch b=new BinarySearch();
		int arr[]={};
		int actual1=b.binarySearch(arr, 0, 0, 0);
	}
}