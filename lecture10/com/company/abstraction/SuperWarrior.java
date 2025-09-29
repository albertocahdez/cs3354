package com.company.abstraction;

public class SuperWarrior extends Warrior {
	private ShieldType swShield;

	public SuperWarrior(int hp, int mhp, int ap, ShieldType swShield) {
		super(hp, mhp, ap);
		this.swShield = swShield;
	}

	@Override
	public void decreaseHP(int amount) {
		if ( amount < 0 ) amount = 0;
		amount = amount / swShield.getDurability();
		swShield.decrease(1);
		super.decreaseHP(amount);
	}
}
