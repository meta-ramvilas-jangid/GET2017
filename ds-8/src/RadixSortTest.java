import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RadixSortTest {
	RadixSort radixSort;
	
	int[] array1,array2,array3;
	int[] sortedArray1;

	@Before
	public void setUp() {
		
		radixSort = new RadixSort();
		
		array1 = new int[]{805,453,90,1,45,32,87,46,33};
		array2 = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
		array3 = new int[]{10,20,30,40,50,60,70};
		
		sortedArray1 = new int[]{1,32,33,45,46,87,90,453,805};
		
	}

	@Test
	public void testDoRadixSort1() {
		assertArrayEquals(sortedArray1,radixSort.radixSort(array1));
	}
	@Test
	public void testDoRadixSort2() {
		assertArrayEquals(array2, radixSort.radixSort(array2));
	}	

}
