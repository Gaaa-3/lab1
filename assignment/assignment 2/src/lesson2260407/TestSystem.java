package lesson2260407;


public class TestSystem {

	public static void assertEquals(String expected, String actual) {
		if (expected.equals(actual)) {
			System.out.println("correct: -> " + actual);
		} else {
			System.err.println("wrong: expected " + expected + " but we got " + actual);
		}
	}

}
