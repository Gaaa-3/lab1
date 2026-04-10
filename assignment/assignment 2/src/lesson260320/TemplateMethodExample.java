package lesson260320;

import java.util.function.Function;

public class TemplateMethodExample {

	public static void main(String[] args) {
		Calc c = new A();
		Calc c2 = new C();

		Calc c3 = new D(y -> y + 2);

		System.out.println(c.calc());
		System.out.println(c2.calc());
		System.out.println(c3.calc());
	}

}

interface Calc {

	int calc();
}

class D extends A {

	private Function<Integer, Integer> yMutator;

	public D(Function<Integer, Integer> f) {
		yMutator = f;
	}

	@Override
	protected void changeY() {
		y = yMutator.apply(y);
	}

}

class A implements Calc {

	int x, y;

	@Override
	public int calc() {
		x++;
		changeY();
		return x + y;
	}

	protected void changeY() {
		y++;
	}
}

class C extends A {

	@Override
	protected void changeY() {
		y--;
	}
}

class B extends A {

	@Override
	public int calc() {
		x++;
		y--;
		return x + y;
	}

}