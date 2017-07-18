import static org.junit.Assert.*;

import org.junit.Test;

public class ReminderTest {
   @Test(expected = IllegalArgumentException.class)
	public void testReminder1() {
		Reminder r=new Reminder();
		int actual=r.rem(2, 0);
		assertEquals(0, actual);
	}
	@Test
	public void testReminder2() {
		Reminder r=new Reminder();
		int actual=r.rem(100, 3);
		assertEquals(1, actual);
	}
	@Test
	public void testReminder3() {
		Reminder r=new Reminder();
		int actual=r.rem(2, 1);
		assertEquals(0, actual);
	}
}
