package calc.cc.openhome;

public class Calculator {
	public int plus(int op1, int op2) {
		return op1 + op2;
	}
	
	public int minus(int op1, int op2) {
		return op1 - op2;
	}
	
	public int multiply(int op1, int op2) {
		return op1 * op2;
	}
	
	public int stringToInt(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NullPointerException e) {
			return 0;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	public int stringToInt2(String s) {
		try {
			return Integer.parseInt(s);
		} catch (NullPointerException e) {
			return 0;
		}
	}
}
