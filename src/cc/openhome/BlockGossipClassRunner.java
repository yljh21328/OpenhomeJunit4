package cc.openhome;

import java.lang.reflect.Method;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class BlockGossipClassRunner extends BlockJUnit4ClassRunner {
	public BlockGossipClassRunner(Class<?> clz) throws InitializationError {
		super(clz);
	}

	@Override
	protected Statement methodInvoker(FrameworkMethod method, Object test) {
		PrePostTestStatement statement = new PrePostTestStatement(super.methodInvoker(method, test), test);
		PreTest preTest = method.getAnnotation(PreTest.class);
		if (preTest != null) {
			addMethod(test, statement, preTest.value(), true);
		}
		PostTest postTest = method.getAnnotation(PostTest.class);
		if (postTest != null) {
			addMethod(test, statement, postTest.value(), false);
		}
		return statement;
	}

	private void addMethod(Object test, PrePostTestStatement statement, String[] methodNames, boolean isPre) {
		for (String methodName : methodNames) {
			Method[] methods = test.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					if (isPre) {
						statement.addPre(method);
					} else {
						statement.addPost(method);
					}
				}
			}
		}
	}
}