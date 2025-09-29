package com.company.abstraction;

public class Warrior extends Character {
	protected int ap;

	public int attack() {
		return ap;
	}

	Warrior(int hp, int mhp, int ap) {
		super(hp, mhp);
		if ( ap < 0 ) ap = 0;
		this.ap = ap;
	}

	public void use(RedPotion redPotion) {
		this.ap = this.ap + redPotion.getValue();
	}

	public void use(BluePotion bluePotion) {
		this.hp = this.hp + bluePotion.getValue();
	}
}
