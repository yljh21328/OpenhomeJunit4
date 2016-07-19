package cc.openhome;

import org.junit.runners.model.Statement;

import java.lang.reflect.Method;
import java.util.List;
import java.util.ArrayList;

public class PrePostTestStatement extends Statement {
	private Statement invoker;
	private Object target;
	private List<Method> preMethods = new ArrayList<Method>();
	private List<Method> postMethods = new ArrayList<Method>();

	public PrePostTestStatement(Statement invoker, Object target) {
		this.invoker = invoker;
		this.target = target;
	}

	@Override
	public void evaluate() throws Throwable {
		for (Method method : preMethods) {
			method.invoke(target, null);
		}

		Throwable throwable = null;
		try {
			invoker.evaluate(); // 記得呼叫下一個Statement
		} catch (Throwable t) {
			throwable = t;
		}

		for (Method method : postMethods) {
			method.invoke(target, null);
		}
		if (throwable != null) {
			throw throwable;
		}
	}

	public void addPre(Method method) {
		preMethods.add(method);
	}

	public void addPost(Method method) {
		postMethods.add(method);
	}
}