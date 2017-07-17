import static org.junit.Assert.*;

import org.junit.Test;

public class LongSequenceTest {

	@Test
	public void testLongestSequence() {
		
		LongSequence ls=new LongSequence();
		int[] arr1={2,3,4,5,6,3,21,5,3,5};
		int[] test1=ls.longestSequence(arr1);
		int[] exp1={2,3,4,5,6};
		assertArrayEquals(exp1, test1);
		
		int[] arr2={1,2,1,2,1,8,6,7,5,9};
		int[] test2=ls.longestSequence(arr2);
		int[] exp2={1,2};
		assertArrayEquals(exp2, test2);
		
		int[] arr3={2,3,4,5,6,3,21,5,3,5,7,9,11,13,15};
		int[] test3=ls.longestSequence(arr3);
		int[] exp3={3,5,7,9,11,13,15};
		assertArrayEquals(exp3, test3);
		
		//fail("Not yet implemented"); // TODO
	}

}
