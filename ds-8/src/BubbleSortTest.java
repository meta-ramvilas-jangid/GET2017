import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BubbleSortTest {

	BubbleSort bubbleSort;
	int[] array1, array2, array3, array4, array5;
	int[] sortedArray1, sortedArray2, sortedArray3, sortedArray4, sortedArray5;

	@Before
	public void setUp() {
		
		bubbleSort = new BubbleSort();
		
		array1 = new int[]{805,453,90,1,45,32,87,46,33};
		array2 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
		array3 = new int[]{10,20,30,40,50,60,70};
		array4 = new int[]{70, 60, 50, 40, 30, 20, 10};
		array5 = new int[]{12, 12, 14, 14, 8, 8, 17, 5};
	
		sortedArray1 = new int[]{1,32,33,45,46,87,90,453,805};
		sortedArray2 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
		sortedArray3 = new int[]{10,20,30,40,50,60,70};
		sortedArray4 = new int[]{10, 20, 30, 40, 50, 60, 70};
		sortedArray5 = new int[]{5, 8, 8, 12, 12, 14, 14, 17};
	}

	@Test
	public void testDoBubbleSort1() {
		
		assertArrayEquals(sortedArray1, bubbleSort.bubbleSort(array1));
	}
	
	@Test
	public void testDoBubbleSort2() {	
		
		assertArrayEquals(array2, bubbleSort.bubbleSort(array2));
	}
	
	@Test
	public void testDoBubbleSort3() {	
		
		assertArrayEquals(array3, bubbleSort.bubbleSort(array3));
	}	
	@Test
	public void testDoBubbleSort4() {	
		
		assertArrayEquals(array4, bubbleSort.bubbleSort(array4));
	}	
	@Test
	public void testDoBubbleSort5() {	
		
		assertArrayEquals(array5, bubbleSort.bubbleSort(array5));
	}
}
