import static org.junit.Assert.*;

import org.junit.Test;
public class GratestCommonDivisorTest {
	@Test
	public void testGcd1(){
		GratestCommonDivisor g=new GratestCommonDivisor();
		int actual=g.gcd(2, 1);
		assertEquals(1, actual);
	}
	@Test
	public void testGcd2(){
		GratestCommonDivisor g=new GratestCommonDivisor();
		int actual=g.gcd(12, 18);
		assertEquals(6, actual);
	}
	@Test
	public void testGcd3(){
		GratestCommonDivisor g=new GratestCommonDivisor();
		int actual=g.gcd(100, 3);
		assertEquals(1, actual);
	}
	@Test
	public void testGcd4(){
		GratestCommonDivisor g=new GratestCommonDivisor();
		int actual=g.gcd(2, 5);
		assertEquals(1, actual);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGcd5(){
		GratestCommonDivisor g=new GratestCommonDivisor();
		int actual=g.gcd(-1, 5);
		//assertEquals(0, actual);
	}
}
