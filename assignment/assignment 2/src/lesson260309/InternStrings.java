package lesson260309;

public class InternStrings {

	public static void main(String[] args) {

		String h1 = "Hello!";

		String h2 = "Hello!";

		String h3 = new String("Hello!");

		System.out.println(h1 == h2);
		System.out.println(h1 == h3);

		Integer i1 = new Integer(10);
		Integer i2 = new Integer(10);

		System.out.println(i1 == i2);

		Integer i3 = 10;
		Integer i4 = 10;

		System.out.println(i3 == i4);

		Integer i5 = Integer.valueOf(10);
		Integer i6 = Integer.valueOf(10);

		System.out.println(i5 == i6);

	}

}
