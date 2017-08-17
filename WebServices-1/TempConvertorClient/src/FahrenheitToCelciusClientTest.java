import static org.junit.Assert.*;

import org.junit.Test;

public class FahrenheitToCelciusClientTest {
	private static final double DELTA = 1e-15;

	@Test
	public void testMain() {

		double d = FahrenheitToCelciusClient.main(98.6);
		assertEquals(37.0, d, DELTA);
	}

	@Test
	public void testMain1() {

		double d = FahrenheitToCelciusClient.main(32.0);
		assertEquals(0, d, DELTA);
	}

	@Test
	public void testMain2() {

		double d = FahrenheitToCelciusClient.main(-12.2);
		assertEquals(-24.56, d, DELTA);
	}

	@Test
	public void testMain3() {

		double d = FahrenheitToCelciusClient.main(0.0);
		assertEquals(-17.78, d, DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMain4() {

		double d = FahrenheitToCelciusClient.main(Double.parseDouble("ram"));
	}

	@Test
	public void testMain5() {

		double d = FahrenheitToCelciusClient.main(Double.parseDouble("12"));
		assertEquals(-11.11, d, DELTA);
	}
}
