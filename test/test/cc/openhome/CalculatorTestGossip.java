package test.cc.openhome;

import org.junit.runner.RunWith;

import calc.cc.openhome.Calculator;
import test.cc.openhome.TestCase;

@RunWith(value = GossipRunner.class)
public class CalculatorTestGossip extends TestCase {
	private Calculator calculator;

	public void setUp() {
		calculator = new Calculator();
	}

	public void tearDown() {
		calculator = null;
	}

	public void testPlus() {
		int expected = 1;
		int result = calculator.plus(3, 2);
		assertEquals(expected, result);
	}

	public void testMinus() {
		int expected = 1;
		int result = calculator.minus(3, 2);
		assertEquals(expected, result);
	}
}