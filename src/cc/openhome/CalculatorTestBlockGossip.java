package cc.openhome;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import calc.cc.openhome.Calculator;
import test.cc.openhome.TestCase;

@RunWith(value = BlockGossipClassRunner.class)
public class CalculatorTestBlockGossip {
	private Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	@After
	public void tearDown() {
		calculator = null;
	}

	public void preTestPlus() {
		System.out.println("preTestPlus");
	}

	public void postTestPlus() {
		System.out.println("postTestPlus");
	}

	@PreTest("preTestPlus")
	@PostTest("postTestPlus")
	@Test
	public void testPlus() {
		int expected = 1;
		int result = calculator.plus(3, 2);
		assertEquals(expected, result);
	}

	@Test
	public void testMinus() {
		int expected = 1;
		int result = calculator.minus(3, 2);
		assertEquals(expected, result);
	}
}