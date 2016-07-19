package test.cc.openhome;

public class Assert {
	public static void assertEquals(String message, int expected, int result) {
		if (expected != result) {
			if (message == null) {
				throw new RuntimeException(String.format("失敗，預期為 %d，但是傳回 %d！", expected, result));
			}
			throw new RuntimeException(String.format(message, expected, result));
		}
	}

	public static void assertEquals(int expected, int result) {
		assertEquals(null, expected, result);
	}
}