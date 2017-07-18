import static org.junit.Assert.*;

import org.junit.Test;

public class LargestDigitTest {

	@Test
	public void testLargestDigit() {
		LargestDigit ld=new LargestDigit();
		int actual=ld.largestDigit(1257369);
		assertEquals(9, actual);
	}
	@Test
	public void testLargestDigit2() {
		LargestDigit ld=new LargestDigit();
		int actual=ld.largestDigit(2);
		assertEquals(2, actual);
	}
	@Test
	public void testLargestDigit3() {
		LargestDigit ld=new LargestDigit();
		int actual=ld.largestDigit(444);
		assertEquals(4, actual);
	}
	@Test
	public void testLargestDigit4() {
		LargestDigit ld=new LargestDigit();
		int actual=ld.largestDigit(0);
		assertEquals(0, actual);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testLargestDigit5() {
		LargestDigit ld=new LargestDigit();
		int actual=ld.largestDigit(-1);
		assertEquals(-1, actual);
	}
}
