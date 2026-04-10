package lesson260320;

public class Dog {

	private abstract class Brain {

		protected abstract void humanWantsToPlay();

		protected abstract void humanOfferedFood();
	}

	private class Hungry extends Brain {

		@Override
		protected void humanWantsToPlay() {
			bite();
		}

		@Override
		protected void humanOfferedFood() {
			eat();
			brain = new Fed();
		}

	}

	private class Fed extends Brain {

		@Override
		protected void humanWantsToPlay() {
			bark();
			brain = new Hungry();
		}

		@Override
		protected void humanOfferedFood() {
			wailTail();
		}

	}

	Brain brain = new Hungry();

	public void play() {
		brain.humanWantsToPlay();
	}

	public void bark() {
		System.out.println("barks");
	}

	public void eat() {
		System.out.println("eats");
	}

	public void feed() {
		brain.humanOfferedFood();
	}

	private void wailTail() {
		System.out.println("wails tail");
	}

	private void bite() {
		System.out.println("bites");
	}

}
