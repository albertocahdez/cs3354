package edu.txst.game;

public class RedPotion extends Potion {

	public RedPotion(int value) {
		super(value);
	}

	@Override
	public int getValue() {
		return 2 * this.value;
	}
}
