package edu.txst.game;

public class Main {
	public static void main(String[] args) {
		/*
		 * CharacterType hero = new CharacterType(5, 10); WarriorType warrior = new WarriorType(3,
		 * 20, 7);
		 * 
		 * // Potion potion = new Potion(3); BluePotion bluePotion = new BluePotion(6); RedPotion
		 * redPotion = new RedPotion(4);
		 * 
		 * System.out.println("Warrior's HP: " + warrior.getHP()); // 3
		 * System.out.println("Warrior's AP: " + warrior.attack()); // 7
		 * System.out.println("=========="); warrior.use(bluePotion); // HP: 9
		 * warrior.use(redPotion); // AP: 15 System.out.println("Warrior's HP: " + warrior.getHP());
		 * System.out.println("Warrior's AP: " + warrior.attack());
		 */

		ShieldType superShield = new ShieldType(5);
		SuperWarrior akira = new SuperWarrior(77, 100, 53, superShield);
		System.out.println(akira);
		akira.decreaseHp(50);
		System.out.println(akira);
	}
}
