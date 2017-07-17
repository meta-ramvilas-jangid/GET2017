import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryToOctalTest {

	@Test
	public void testConvertBinaryToOctal() {
		
		BinaryToOctal bto=new BinaryToOctal();
		int test1=bto.convertBinaryToOctal(110101);
		assertEquals(65,test1);
		
		int test2=bto.convertBinaryToOctal(11010);
		assertEquals(32,test2);
		
		int test3=bto.convertBinaryToOctal(1101);
		assertEquals(15,test3);
		
		
		int test6=bto.convertBinaryToOctal(1000100);
		assertEquals(104,test6);

		//fail("Not yet implemented"); // TODO
	}

}
