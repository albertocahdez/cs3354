package com.company.abstraction;

class Character {
	protected int hp;
	protected int mhp;

	public void decreaseHP(int amount) {
		hp = hp - amount;
		if ( hp < 0 ) hp = 0;
		if ( hp > mhp ) hp = mhp;
	}

	Character(int hp, int mhp) {
		if ( mhp < 1) mhp = 1;
		if ( hp > mhp ) hp = mhp;
		if ( hp < 1 ) hp = 1;
		this.mhp = mhp;
		this.hp = hp;
	}
}