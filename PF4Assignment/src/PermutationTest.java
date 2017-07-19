import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PermutationTest {

	@Test(expected = NullPointerException.class)
	public void test() {
		Permutation p=new Permutation();
		p.permute(null);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test1() {
		Permutation p=new Permutation();
		p.permute("");
		
	}

	@Test
	public void test2() {
		Permutation p=new Permutation();
		List<String> expected = new ArrayList<String>();
		expected.add("ABC");
		expected.add("ACB");
		expected.add("BAC");
		expected.add("BCA");
		expected.add("CBA");
		expected.add("CAB");
		List<String> actual = p.permute("ABC");
		assertArrayEquals(expected.toArray(), actual.toArray());
		
	}
	
	@Test
	public void test3() {
		Permutation p=new Permutation();
		List<String> expected = new ArrayList<String>();
		expected.add("ABCD");
		expected.add("ABDC");
		expected.add("ACBD");
		expected.add("ACDB");
		expected.add("ADCB");
		expected.add("ADBC");
		
		expected.add("BACD");
		expected.add("BADC");
		expected.add("BCAD");
		expected.add("BCDA");
		expected.add("BDCA");
		expected.add("BDAC");
		
		expected.add("CBAD");
		expected.add("CBDA");
		expected.add("CABD");
		expected.add("CADB");
		expected.add("CDAB");
		expected.add("CDBA");
		
		expected.add("DBCA");
		expected.add("DBAC");
		expected.add("DCBA");
		expected.add("DCAB");
		expected.add("DACB");
		expected.add("DABC");
		List<String> actual = p.permute("ABCD");
		assertArrayEquals(expected.toArray(), actual.toArray());
		
	}
	
	@Test
	public void test5() {
		Permutation p=new Permutation();
		List<String> expected = new ArrayList<String>();
		expected.add("AB");
		expected.add("BA");
		List<String> actual = p.permute("AB");
		assertArrayEquals(expected.toArray(), actual.toArray());
		
	}
}
