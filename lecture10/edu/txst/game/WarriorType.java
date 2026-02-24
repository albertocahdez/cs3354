package edu.txst.game;

public class WarriorType extends CharacterType {
	protected int ap;

	public int attack() {
		return ap;
	}

	public void use(BluePotion bluePotion) {
		this.hp = this.hp + bluePotion.getValue();
		if (this.hp > this.mhp)
			this.hp = this.mhp;
	}

	public void use(RedPotion redPotion) {
		this.ap = this.ap + redPotion.getValue();
	}

	public WarriorType(int hp, int mhp, int ap) {
		super(hp, mhp);
		if (ap < 0)
			ap = 0;
		this.ap = ap;
	}
}
