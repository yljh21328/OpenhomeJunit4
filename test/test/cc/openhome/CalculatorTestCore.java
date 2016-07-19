package test.cc.openhome;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import calc.cc.openhome.Calculator;

public class CalculatorTestCore {
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
		// int expected = 5;
		int expected = 4;
		int result = calculator.plus(3, 2);
		assertEquals(expected, result);
	}

	@Test
	public void testMinus() {
		int expected = 2;
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

	public static void main(String[] args) {
		//Result result = JUnitCore.runClasses(CalculatorTestCore.class);
		JUnitCore junitCore = new JUnitCore();
		junitCore.addListener(new RunListener() {
			public void testRunStarted(Description description) throws Exception {
				System.out.println(description.getDisplayName() + "... test run started");
			}

			public void testRunFinished(Result result) throws Exception {
				System.out.println("All Finished");
			}

			public void testStarted(Description description) throws Exception {
				System.out.println(description.getDisplayName() + "... test started");
			}

			public void testFinished(Description description) throws Exception {
				System.out.println(description.getDisplayName() + "... test finished");
			}

			public void testFailure(Failure failure) throws Exception {
				System.out.println(failure.getTestHeader() + ": " + failure.getMessage() + " test failed");
			}

			public void testAssumptionFailure(Failure failure) {
				System.out.println("assumption failed");
			}

			public void testIgnored(Description description) throws Exception {
				System.out.println(description.getDisplayName() + "... test ignored");
			}

		});
		Result result = junitCore.run(CalculatorTestCore.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.getTestHeader() + ": " + failure.getMessage());
		}
	}

}
