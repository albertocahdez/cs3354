package edu.txst.game;

public class CharacterType {
	protected int hp;
	protected int mhp;

	public void decreaseHp(int amount) {
		this.hp = this.hp - amount;
		if (this.hp < 0)
			this.hp = 0;
	}

	public int getHP() {
		return hp;
	}

	public CharacterType(int hp, int mhp) {
		if (mhp < 1)
			mhp = 1; // default mhp equal to 1
		this.mhp = mhp;
		if (hp > mhp)
			hp = mhp; // default hp is equal to mhp
		this.hp = hp;
	}
}
