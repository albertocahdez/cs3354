package edu.txst.game;

public class Pig implements Animal {

	@Override
	public void makeSound() {
		System.out.println("The pig says: wee wee");
	}

	public void sleep() {
		System.out.println("Zzz");
	}

	public static void main(String[] args) {
		Animal animal0 = new Pig();
		animal0.makeSound();

		Animal animal1 = new Cat();
		animal1.makeSound();
	}
}
