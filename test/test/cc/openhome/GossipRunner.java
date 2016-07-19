package test.cc.openhome;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import test.cc.openhome.Test;
import test.cc.openhome.TestCase;
import test.cc.openhome.TestResult;
import test.cc.openhome.TestSuite;

public class GossipRunner extends Runner {
	private Test test;
	private Class<?> clz;

	public GossipRunner(Class<?> clz) {
		this.test = new TestSuite(clz.asSubclass(TestCase.class));
		this.clz = clz;
	}

	@Override
	public Description getDescription() {
		return makeDescription(clz, test);
	}

	public static Description makeDescription(Class<?> clz, Test test) {
		if (test instanceof TestCase) {
			TestCase testCase = (TestCase) test;
			return Description.createTestDescription(clz, testCase.getName());
		} else if (test instanceof TestSuite) {
			Description description = Description.createSuiteDescription(clz);
			TestSuite suite = (TestSuite) test;
			for (Test t : suite.get()) {
				TestCase testCase = (TestCase) t;
				description.addChild(makeDescription(clz, testCase));
			}
			return description;
		} else {
			return Description.createSuiteDescription(test.getClass());
		}
	}

	@Override
	public void run(final RunNotifier notifier) {
		TestResult result = new TestResult() {
			@Override
			public void run(TestCase test) {
				Description description = makeDescription(clz, test);
				notifier.fireTestStarted(description);
				try {
					test.run();
				} catch (Throwable t) {
					notifier.fireTestFailure(new Failure(description, t));
				}
				notifier.fireTestFinished(description);
			}
		};
		test.runTest(result);
	}
}