package test.cc.openhome;

import java.lang.reflect.*;

public class TestCase extends Assert implements Test {
	private String fName;

	public TestCase() {
	}

	public TestCase(String name) {
		fName = name;
	}

	protected void setUp() {
	}

	protected void tearDown() {
	}

	@Override
	public void runTest(TestResult result) {
		result.run(this);
	}

	public void run() {
		setUp();
		runTest();
		tearDown();
	}

	public void runTest() {
		Method runMethod = null;
		try {
			runMethod = getClass().getMethod(fName, null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		if (!Modifier.isPublic(runMethod.getModifiers())) {
			throw new RuntimeException("方法 \"" + fName + "\" 必須是 public");
		}
		try {
			// invoke 中發生所有例外，一律會用InvocationTargetException包裹
			runMethod.invoke(this, new Class[0]);
		} catch (InvocationTargetException e) {
			// 這邊要取得InvocationTargetException 中的目標例外，才是真正的錯誤訊息
			throw new RuntimeException(
					this.getClass() + "." + runMethod.getName() + ": " + e.getTargetException().getMessage());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getName() {
		return fName;
	}

	public void setName(String name) {
		fName = name;
	}
}