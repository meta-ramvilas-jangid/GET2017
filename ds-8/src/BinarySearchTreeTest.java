import static org.junit.Assert.*;
import org.junit.Test;
public class BinarySearchTreeTest {

	@Test
	public void testGetSortedOrder1() {

		int arr[] = { 13, 45, 1, 30, 15, 2 };
		BinarySearchTree b = new BinarySearchTree();
		b.createBSTFromArray(arr, arr.length);
		int actual[] = b.inorder();
		int exp[] = { 1, 2, 13, 15, 30, 45 };
		assertArrayEquals(exp, actual);
	}
	
	@Test
	public void testGetSortedOrder2() {

		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		BinarySearchTree b = new BinarySearchTree();
		b.createBSTFromArray(arr, arr.length);
		int actual[] = b.inorder();
		int exp[] = {1, 2, 3, 4, 5, 6, 7};
		assertArrayEquals(exp, actual);
	}

	@Test
	public void testGetSortedOrder3() {

		int arr[] = {1, 1, 1, 1, 1, 1, 1, 1};
		BinarySearchTree b = new BinarySearchTree();
		b.createBSTFromArray(arr, arr.length);
		int actual[] = b.inorder();
		int exp[] = {1, 1, 1, 1, 1, 1, 1, 1};
		assertArrayEquals(exp, actual);
	}
	
	@Test
	public void testGetSortedOrder4() {

		int arr[] = {17, 11, 9, 7, 4, 2, 0};
		BinarySearchTree b = new BinarySearchTree();
		b.createBSTFromArray(arr, arr.length);
		int actual[] = b.inorder();
		int exp[] = {0, 2, 4, 7, 9, 11, 17};
		assertArrayEquals(exp, actual);
	}
}

