package edu.txst.game;

public class SuperWarrior extends WarriorType {
	ShieldType shield;

	public SuperWarrior(int hp, int mhp, int ap, ShieldType shield) {
		super(hp, mhp, ap);
		this.shield = shield;
	}

	@Override
	public void decreaseHp(int amount) {
		amount = amount / shield.getDurability();
		super.decreaseHp(amount);
		shield.decreaseDurability(1);
	}

	@Override
	public String toString() {
		return "[hp=" + hp + ", mhp=" + mhp + ", ap=" + ap + ", sd=" + shield.getDurability() + "]";
	}
}
