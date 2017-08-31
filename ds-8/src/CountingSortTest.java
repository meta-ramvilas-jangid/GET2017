import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CountingSortTest {


	CountingSort countingSort;
	int[] array1, array2, array3, array4, array5;
	int[] sortedArray1, sortedArray2, sortedArray3, sortedArray4, sortedArray5;

	@Before
	public void setUp() {
		
		countingSort = new CountingSort();
		
		array1 = new int[]{90,1,45,32,87,46,33};
		array2 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
		array3 = new int[]{10,20,30,40,50,60,70};
		array4 = new int[]{70, 60, 50, 40, 30, 20, 10};
		array5 = new int[]{12, 12, 14, 14, 8, 8, 17, 5};
	
		sortedArray1 = new int[]{1,32,33,45,46,87,90};
		sortedArray2 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
		sortedArray3 = new int[]{10,20,30,40,50,60,70};
		sortedArray4 = new int[]{10, 20, 30, 40, 50, 60, 70};
		sortedArray5 = new int[]{5, 8, 8, 12, 12, 14, 14, 17};
	}

	@Test
	public void testDoCountingSort1() {
		
		assertArrayEquals(sortedArray1, countingSort.countingSort(array1));
	}
	
	@Test
	public void testDoCountingSort2() {
		
		assertArrayEquals(sortedArray2, countingSort.countingSort(array2));
	}
	@Test
	public void testDoCountingSort3() {
		
		assertArrayEquals(sortedArray3, countingSort.countingSort(array3));
	}
	@Test
	public void testDoCountingSort4() {
		
		assertArrayEquals(sortedArray4, countingSort.countingSort(array4));
	}
	@Test
	public void testDoCountingSort5() {
		
		assertArrayEquals(sortedArray5, countingSort.countingSort(array5));
	}
}
