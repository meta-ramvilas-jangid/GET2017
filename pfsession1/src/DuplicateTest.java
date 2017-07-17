import static org.junit.Assert.*;

import org.junit.Test;

public class DuplicateTest {

	@Test
	public void testRemoveDuplicate() {
		Duplicate d=new Duplicate();
	
		int[] arr1={2,5,4,6,3,8,5,9,3,3,6,3,9,0};
		int[] exp1={2,5,4,6,3,8,9,0};
	    int[] arr2=d.removeDuplicate(arr1);
			
		assertArrayEquals(exp1, arr2);
		
		int[] arr3={2,5,-4,6,3,8,5,9,3,3,6,3,9,0};
		int[] exp3={2,5,-4,6,3,8,9,0};
	    int[] arr4=d.removeDuplicate(arr3);
			
		assertArrayEquals(exp3, arr4);
		
	
		//fail("Not yet implemented"); // TODO
	}

}
