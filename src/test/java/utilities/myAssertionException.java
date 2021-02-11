package utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class myAssertionException extends Throwable {

	private static final long serialVersionUID = 1L;

	boolean enableSuppression = false;
	boolean writableStackTrace = false;

	public myAssertionException() {
	}

	// static String[] emoji = { "¯\\_(ツ)_/¯", "(/•-•)/", "¯\\(°_o)/¯", "o_O",
	// "(⊙_☉)" };

	// static int i = 0 + (int) (Math.random() * ((4 - 0) + 1));

	public myAssertionException(String message) {
		super(message, null, false, false);

		// super(message + "\n\n" + emoji[i], null, false, false);
		// i = 0 + (int) (Math.random() * ((4 - 0) + 1));
	}

	public myAssertionException(String expected, String actual) {
		super("Expected : " + expected + "Actual : " + actual, null, false, false);
	}

	public static void myAssertion(String type, String Expected, String Actual) throws Throwable {
		try {
			assertEquals(Expected, Actual);
		} catch (Throwable e) {
			
			String errorCode = ComparisionHolder.setComparedVarialbes(type, Expected, Actual);
			throw new myAssertionException(errorCode);
		}
	}


	public static void myAssertion(String Expected, String Actual) throws Throwable {
		try {
			assertEquals(Expected, Actual);
		} catch (Throwable e) {
			
			String errorCode = ComparisionHolder.setComparedVarialbes("text", Expected, Actual);
			throw new myAssertionException(errorCode);
		}
	}
}