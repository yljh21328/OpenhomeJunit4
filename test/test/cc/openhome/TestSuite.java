package test.cc.openhome;

import java.lang.reflect.*;
import java.util.*;

public class TestSuite implements Test {
	private List<Test> tests = new ArrayList<Test>();

	public TestSuite() {
	}

	public TestSuite(Class clz) {
		Method[] methods = clz.getDeclaredMethods();
		for (Method method : methods) {
			if (Modifier.isPublic(method.getModifiers()) && method.getName().startsWith("test")) {
				Constructor constructor = null;
				try {
					constructor = clz.getConstructor();
					TestCase testCase = (TestCase) constructor.newInstance();
					testCase.setName(method.getName());
					add(testCase);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	@Override
	public void runTest(TestResult result) {
		for (Test test : tests) {
			test.runTest(result);
		}
	}

	public void add(Test test) {
		tests.add(test);
	}

	public void add(Class clz) {
		tests.add(new TestSuite());
	}

	public List<Test> get() {
		return tests;
	}
}