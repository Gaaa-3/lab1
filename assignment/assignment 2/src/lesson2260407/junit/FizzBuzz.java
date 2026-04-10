package lesson2260407.junit;


public class FizzBuzz {

	public String evaluate(int i) {

		String result = "";

		if (i % 3 == 0) {
			result += "Fizz";
		}

		if (i % 5 == 0) {
			result += "Buzz";
		}

		return result.isEmpty() ? Integer.toString(i) : result;
	}

}
