package lesson260309;

public class ShallowCopy {

	public static void main(String[] args) {

		A a = new A();
		System.out.println(a);

		A clone = a.copy();
		System.out.println(clone);

		a.b.change();

		System.out.println(clone);

	}

}

class A implements Cloneable {

	B b = new B();

	@Override
	public String toString() {
		return "we have " + b;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public A copy() {
		try {
			return (A) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

}

class B {

	int state = 0;

	void change() {
		state++;
	}

	@Override
	public String toString() {
		return "state = " + state;
	}
}
