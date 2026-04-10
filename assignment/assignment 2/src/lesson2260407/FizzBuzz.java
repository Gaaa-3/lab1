package lesson2260407;


public class FizzBuzz {

	String evaluate(int number) {
		if (number == 0) {
			throw new IllegalArgumentException("zero is not allowed");
		}
		
		String result = "";

		if (number % 3 == 0) {
			result += "Fizz";
		}
		
		if (number % 5 == 0) {
			result += "Buzz";
		}
		
		return result.isEmpty() ? Integer.toString(number) : result;
	}

	public static void main(String[] args) {
		FizzBuzz f = new FizzBuzz();

		testFor0(f);
		testFor3(f);
		testFor5(f);
		testNumber(f, 6, "Fizz");
		testNumber(f, 10, "Buzz");
		testNumber(f, 7, "7");
		testNumber(f, 15, "FizzBuzz");

	}

	private static void testNumber(FizzBuzz f, int number, String expected) {
		String result = f.evaluate(number);
		TestSystem.assertEquals(expected, result);
	}

	private static void testFor3(FizzBuzz f) {
		testNumber(f, 3, "Fizz");
	}

	private static void testFor5(FizzBuzz f) {
		testNumber(f, 5, "Buzz");
	}

	private static void testFor0(FizzBuzz f) {
		try {
			String result = f.evaluate(0);
		} catch (IllegalArgumentException iae) {
			System.out.println("correct: " + iae.getMessage());
			return;
		}
		System.out.println("incorrect: expected exception");
	}

}
