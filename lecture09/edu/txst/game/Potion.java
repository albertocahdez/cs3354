package edu.txst.game;

public abstract class Potion {
	protected int value;

	public abstract int getValue(); // abstract

	public Potion(int value) {
		if (value < 1)
			this.value = 1;
		this.value = value;
	}
}
