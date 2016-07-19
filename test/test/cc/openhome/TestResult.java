package test.cc.openhome;

import java.util.*;

public class TestResult {
	private List<String> messages = new ArrayList<String>();

	public void run(TestCase test) {
		try {
			test.run();
		} catch (Throwable t) {
			messages.add(t.getMessage());
		}
	}

	public List<String> getMessages() {
		return messages;
	}
}