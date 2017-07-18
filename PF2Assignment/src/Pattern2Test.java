import static org.junit.Assert.*;
import org.junit.Test;
public class Pattern2Test {
	@Test
	public void testSpace1() {
		Pattern2 p1=new Pattern2();
		String test1=p1.space(1, 5);
		assertEquals("", test1);
	}
        @Test
	public void testNumber1() {
	  	  Pattern2 p1=new Pattern2();
		  String test1=p1.number(1, 5);
		  assertEquals("12345", test1);
	}
	@Test
	public void testPrint1() {
          	 Pattern2 p1=new Pattern2();
		 String test1[]=p1.print(5);
		 String excepted[]={"12345",
				            " 1234",
				            "  123",
				            "   12",
				            "    1"};
		 assertArrayEquals(excepted, test1);
	}
        @Test
	public void testSpace2() {
                   Pattern2 p1=new Pattern2();
		   String test1=p1.space(2, 4);
		   assertEquals(" ", test1);
	}
        @Test
	public void testNumber2() {
		   Pattern2 p1=new Pattern2();
		   String test1=p1.number(2, 4);
		   assertEquals("123", test1);
	}
        @Test
	public void testPrint2() {
                 Pattern2 p1=new Pattern2();
		 String test1[]=p1.print(4);
		 String excepted[]={"1234",
				            " 123",
				            "  12",
				            "   1"};
		 assertArrayEquals(excepted,test1);
	}
	@Test
	public void testSpace3() {

		   Pattern2 p1=new Pattern2();
		   String test1=p1.space(5, 5);
		   assertEquals("    ", test1);
	}

	@Test
	public void testNumber3() {

		   Pattern2 p1=new Pattern2();
		   String test1=p1.number(3, 5);
		   assertEquals("123", test1);
        }
	@Test
	public void testPrint3() {
		Pattern2 p1=new Pattern2();
		 String test1[]=p1.print(6);
		 String excepted[]={"123456",
				            " 12345",
				            "  1234",
				            "   123",
				            "    12",
				            "     1"}; 
		 assertArrayEquals(excepted, test1);
	}	
}
