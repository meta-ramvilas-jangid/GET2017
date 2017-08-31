import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CountingSortTest {


	CountingSort countingSort;
	int[] array1,array2,array3;
	int[] sortedArray1;

	@Before
	public void setUp() {
		
		countingSort = new CountingSort();
		
		array1 = new int[]{80,45,90,1,45,32,87,46,33};
		array2 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
		array3 = new int[]{10,20,30,40,50,60,70};
		
		sortedArray1 = new int[]{1,32,33,45,45,46,80,87,90};
	}

	@Test
	public void testDoCountingSort1() {
		
		assertArrayEquals(sortedArray1, countingSort.countingSort(array1));
		assertArrayEquals(array2, countingSort.countingSort(array2));
		assertArrayEquals(array3, countingSort.countingSort(array3));
	}
	
	@Test
	public void testDoCountingSort2() {	
		assertArrayEquals(array2, countingSort.countingSort(array2));
	}
}
