package edu.txst.game;

public class ShieldType {
	private int durability;

	public int getDurability() {
		return durability;
	}

	public void decreaseDurability(int decrement) {
		durability = durability - decrement;
		if (durability < 1)
			durability = 1;
	}

	public ShieldType(int durability) {
		if (durability < 1)
			durability = 1;
		this.durability = durability;
	}
}
