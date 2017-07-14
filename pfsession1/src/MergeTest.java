import static org.junit.Assert.*;

import org.junit.Test;

public class MergeTest {

	@Test
	public void testJoin() {
		
		int[] arr1={1,7,9,11,14,16};
        int arr1_Length=6;
		int[] arr2={1,8,8,11,13,17};
		int arr2_Length=6;
		Merge m=new Merge();
		int result[]=new int[arr1_Length+arr2_Length];
		int[] act1=m.join(arr1, 6, arr2, 6, result);
		int[] exp1={1,1,7,8,8,9,11,11,13,14,16,17};
		assertArrayEquals(exp1,act1);
		//fail("Not yet implemented"); // TODO
	}

}
