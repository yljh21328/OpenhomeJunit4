package test.cc.openhome;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import calc.cc.openhome.Calculator;

public class CalculatorTest2 {
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
		//int expected = 4;
		int result = calculator.plus(3, 2);
		assertEquals(expected, result);
	}

	@Test
	public void testMinus() {
		int expected = 1;
		int result = calculator.minus(3, 2);
		assertEquals(expected, result);
	}

	@Ignore("testMultiply not implement")
	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

	@Test(expected = NumberFormatException.class, timeout=2000)
	public void testStringToInt() {
		 //If the test case run exceeds 2 second, jUnit will interrupt and record it as a error.
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		calculator.stringToInt2("hello");
	}
	
	@Test
	public void testError() {
		int expected = 0;
		//This test case will be Error instead of Failure
		//Case1
		int result = calculator.stringToInt2("hello");
		
		//Case2
		String numStr = "world";
		int num = Integer.parseInt(numStr);
		System.out.println(num);
		assertEquals(expected, result);
	}

}
