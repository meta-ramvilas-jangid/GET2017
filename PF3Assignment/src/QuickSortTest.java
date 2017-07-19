import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void testQuicksort() {
		QuickSort q=new QuickSort();
		int a[]={2,5,8,9,10,77,55,11};
		int arr[]=q.quicksort(a, 0, 7);
		int expect[]={2,5,8,9,10,11,55,77};
		assertArrayEquals(expect, arr);
	}
	@Test
	public void testQuicksort1() {
		QuickSort q=new QuickSort();
		int a[]={2,2,2,2,2,2};
		int arr[]=q.quicksort(a, 0, 5);
		int expect[]={2,2,2,2,2,2};
		assertArrayEquals(expect, arr);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testQuicksort2() {
		QuickSort q=new QuickSort();
		int a[]={};
		int arr[]=q.quicksort(a, 0, 0);
		int expect[]={};
		assertArrayEquals(expect, arr);
	}
	@Test
	public void testQuicksort3() {
		QuickSort q=new QuickSort();
		int a[]={9,9};
		int arr[]=q.quicksort(a, 0, 1);
		int expect[]={9,9};
		assertArrayEquals(expect, arr);
	}
}
