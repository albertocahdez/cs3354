package com.company.abstraction;

public class ShieldType {
	private int durability;

	public int getDurability() {
		return durability;
	}

	public void decrease(int amount) {
		durability = durability - amount;
		if (durability < 1) durability = 1;
	}

	public ShieldType(int durability) {
		if ( durability < 1 ) durability = 1;
		this.durability = durability;
	}
}
