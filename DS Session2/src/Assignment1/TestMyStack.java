package Assignment1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMyStack {

	MyStack<String> stack;
	@Before
	public void setUp() throws Exception {
		stack = new MyStack<String>();
	}

	// Check the method of push and pop of stack
	@Test
	public void testPop(){
		stack.push("A");
		assertEquals("A" , stack.pop());
	}
	
	// Check the method peek of stack
	@Test
	public void testPeek(){
		stack.push("A");
		stack.push("B");
		assertEquals("B", stack.peek());
	}
}
