package lesson260309;

public class Singleton {

	private static Singleton instance = new Singleton();

	private Singleton() {

	}

	public static Singleton instance() {
		return instance;
	}

}
