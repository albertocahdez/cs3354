package com.company.abstraction;

public abstract class PotionType {
	protected int value;

	public abstract int getValue();
	
	public final void setValue(int value) {
		if ( value < 1 ) value = 1;
		this.value = value;
	}
}
