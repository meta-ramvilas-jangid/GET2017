import static org.junit.Assert.*;

import org.junit.Test;


public class BinarySearchTreeTest {

BinarySearchTree treeSort;
	


	@Test
	public void testGetSortedOrder() {
		
		int arr[]={13,45,1,30,15,2};
		BinarySearchTree b=new BinarySearchTree();
		b.createBSTFromArray(arr, arr.length);
		int actual[] =b.inorder();
		int exp[]={1,2,13,15,30,45};
		assertArrayEquals(exp , actual);
	}

	
	
	

}
