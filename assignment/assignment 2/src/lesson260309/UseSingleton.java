package lesson260309;

public class UseSingleton {

	public static void main(String[] args) {

		Singleton s = Singleton.instance();
		Singleton s2 = Singleton.instance();

		System.out.println(s);
		System.out.println(s2);

	}

}
