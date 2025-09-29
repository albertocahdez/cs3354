package com.company.abstraction;

public class BluePotion extends PotionType {
	@Override
	public int getValue() {
		return value;
	}

	BluePotion(int value) {
		setValue(value);
	}
}
