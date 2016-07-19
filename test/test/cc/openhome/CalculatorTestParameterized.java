package test.cc.openhome;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import calc.cc.openhome.Calculator;

@RunWith(value=Parameterized.class)
public class CalculatorTestParameterized {
	@Parameterized.Parameters
	public static Collection<Integer[]> getParameters() {
		return Arrays.asList(new Integer[][] {
			{5,3,2},
			{3,1,2},
			{2,1,1}
		});
	}
	
	private int expected;
	private int para1;
	private int para2;
	private Calculator calculator;

	public CalculatorTestParameterized(int expected, int para1, int para2) {
		this.expected = expected;
		this.para1 = para1;
		this.para2 = para2;
	}
	
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
		int result = calculator.plus(para1, para2);
		assertEquals(expected, result);
	}
}
