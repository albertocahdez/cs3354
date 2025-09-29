package com.company.abstraction;

public class RedPotion extends PotionType {
	@Override
	public int getValue() {
		return value * 2;
	}
	RedPotion(int value) {
		setValue(value);
	}
}
