import static org.junit.Assert.*;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testCheckOrder() {
		 Order o=new Order();
		 int[] arr={1,2,5,8,9,11};
	     int status=o.checkOrder(arr);
	     assertEquals(1,status);
	     

		 int[] arr1={11,9,5,3,2,1};
	     int status1=o.checkOrder(arr1);
	     assertEquals(2,status1);

	    
	    int[] arr2={11,9,13,3,2,1};
	    int status2=o.checkOrder(arr2);
	    assertEquals(0,status2);

	    //fail("Not yet implemented"); // TODO
	}

}
