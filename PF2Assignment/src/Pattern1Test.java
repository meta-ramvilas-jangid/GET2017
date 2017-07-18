import static org.junit.Assert.*;
import org.junit.Test;
public class Pattern1Test {
        @Test
	public void testSpace1() {
	   Pattern1 p1=new Pattern1();
	   String test1=p1.space(1, 5);
	   assertEquals("    ", test1);
	}
	@Test
	public void testNumber1() {
		   Pattern1 p1=new Pattern1();
		   String test1=p1.number(1, 5);
		   assertEquals("1", test1);
	}
        @Test
	public void testPrint1() {
		 Pattern1 p1=new Pattern1();
		 String test1[]=p1.print(5);
		 String excepted[]={"    1",
				            "   121",
				            "  12321",
				            " 1234321",
				            "123454321",
				            " 1234321",
				            "  12321",
				            "   121",
				            "    1"};
		 assertArrayEquals(excepted, test1);
	}
	@Test
	public void testSpace2() {
		   Pattern1 p1=new Pattern1();
		   String test1=p1.space(2, 4);
		   assertEquals("  ", test1);
	}
        @Test
	public void testNumber2() {
		   Pattern1 p1=new Pattern1();
		   String test1=p1.number(2, 4);
		   assertEquals("121", test1);	
        }
	@Test
	public void testPrint2() {
		 Pattern1 p1=new Pattern1();
		 String test1[]=p1.print(4);
		 String excepted[]={"   1",
				            "  121",
				            " 12321",
				            "1234321",
				            " 12321",
				            "  121",
				            "   1"};
		 assertArrayEquals(excepted,test1);
	}
        @Test
	public void testSpace3() {
		   Pattern1 p1=new Pattern1();
		   String test1=p1.space(6, 5);
		   assertEquals(" ", test1);
	}
        @Test
	public void testNumber3() {
		   Pattern1 p1=new Pattern1();
		   String test1=p1.number(6, 5);
		   assertEquals("1234321", test1);
	}
        @Test
	public void testPrint3() {
		Pattern1 p1=new Pattern1();
		 String test1[]=p1.print(6);
		 String excepted[]={"     1",
				            "    121",
				            "   12321",
				            "  1234321",
				            " 123454321",
				            "12345654321",
				            " 123454321",
				            "  1234321",
				            "   12321",
				            "    121",
				            "     1"};  
		 assertArrayEquals(excepted, test1);
	}
}
