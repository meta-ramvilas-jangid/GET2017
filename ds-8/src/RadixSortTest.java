import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class RadixSortTest {
	RadixSort radixSort;
	
	int[] array1, array2, array3, array4, array5;
	int[] sortedArray1, sortedArray2, sortedArray3, sortedArray4, sortedArray5;


	@Before
	public void setUp() {
		
		radixSort = new RadixSort();
		
		array1 = new int[]{190,1,245,332,1487,146,33};
		array2 = new int[]{104, 104, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114};
		array3 = new int[]{10,220,330,440,550,660,770};
		array4 = new int[]{770, 760, 750, 740, 730, 720, 710};
		array5 = new int[]{1212, 1212, 1214, 1214, 128, 128, 1217, 125};
	
		sortedArray1 = new int[]{1, 33, 146, 190, 245, 332, 1487};
		sortedArray2 = new int[]{104, 104, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114};
		sortedArray3 = new int[]{10, 220, 330, 440, 550, 660, 770};
		sortedArray4 = new int[]{710, 720, 730, 740, 750, 760, 770};
		sortedArray5 = new int[]{125, 128, 128, 1212, 1212, 1214, 1214, 1217};
	}

	@Test
	public void testDoRadixSort1() {
		assertArrayEquals(sortedArray1,radixSort.radixSort(array1));
	}
	
	@Test
	public void testDoRadixSort2() {
		assertArrayEquals(sortedArray2,radixSort.radixSort(array2));
	}
	
	@Test
	public void testDoRadixSort3() { 
		assertArrayEquals(sortedArray3, radixSort.radixSort(array3));
	}
	
	@Test
	public void testDoRadixSort4() {
		assertArrayEquals(sortedArray4, radixSort.radixSort(array4));
	}
	
	@Test
	public void testDoRadixSort5() {
		assertArrayEquals(sortedArray5, radixSort.radixSort(array5));
	}

}
