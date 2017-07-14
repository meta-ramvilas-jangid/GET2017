import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class FcfsTest {

	@Test
	public void testFcfs() {

		Fcfs f=new Fcfs();
		int arr[]={1,5,9,25},size[]={12,7,2,5};
		int exp[][]={{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
		int actual[][]=f.fcfs(arr, size);
		assertArrayEquals(exp, actual);
		
		int arr1[]={1,1,3,9},size1[]={3,5,2,5};
		int exp1[][]={{1,1,0,1,3},{2,1,3,4,8},{3,3,6,9,10},{4,9,2,11,15}};
		int actual1[][]=f.fcfs(arr1, size1);
		assertArrayEquals(exp1, actual1);

		//fail("Not yet implemented"); // TODO
	}

}
