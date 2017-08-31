import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BubbleSortTest {

	BubbleSort bubbleSort;
	int[] array1,array2,array3;
	int[] sortedArray1;

	@Before
	public void setUp() {
		
		bubbleSort = new BubbleSort();
		
		array1 = new int[]{805,453,90,1,45,32,87,46,33};
		array2 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
		array3 = new int[]{10,20,30,40,50,60,70};
		
		sortedArray1 = new int[]{1,32,33,45,46,87,90,453,805};
	}

	@Test
	public void testDoBubbleSort() {
		
		assertArrayEquals(sortedArray1, bubbleSort.bubbleSort(array1));
		
	}
	
	@Test
	public void testDoBubbleSort1() {	
		assertArrayEquals(array2, bubbleSort.bubbleSort(array2));
		
	}
}
