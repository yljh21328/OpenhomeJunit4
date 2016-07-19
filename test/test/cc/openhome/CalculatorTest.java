package test.cc.openhome;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.hasItems;

import calc.cc.openhome.Calculator;

public class CalculatorTest {
	private Calculator calculator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		calculator = null;
	}

	@Test
	public void testPlus() {
		int expected = 5;
		// int expected = 4;
		int result = calculator.plus(3, 2);
		assertEquals(expected, result);
	}

	@Test
	public void testMinus() {
		int expected = 1;
		int result = calculator.minus(3, 2);
		assertEquals(expected, result);
	}

	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	public void testStringToInt() {
		try {
			calculator.stringToInt("123");
			calculator.stringToInt("hello");
			fail("No throw expected Exception");
		} catch (NumberFormatException e) {
			System.out.println("There kind of exception is not considered.");
		}
	}

	@Test
	public void testError() {
		int expected = 0;
		// This test case will be Error instead of Failure
		// Case1
		int result = calculator.stringToInt2("hello");

		// Case2
		String numStr = "world";
		int num = Integer.parseInt(numStr);
		System.out.println(num);
		assertEquals(expected, result);
	}

	@Test
	public void testGenerate() {
		List<String> guest = new ArrayList<String>();
		guest.add("Justin");
		guest.add("Momor");
		guest.add("Hamimi");

		//assertTrue(guest.contains("Justin") && guest.contains("Momor") && guest.contains("Hamimi"));
		assertThat(guest, hasItems("Justin", "Momor", "Hamimi"));
	}

}
