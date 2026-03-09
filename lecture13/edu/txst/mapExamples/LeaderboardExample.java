package edu.txst.mapExamples;

import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;

public class LeaderboardExample {
	public static void main(String[] args) {
		// Create a TreeMap that sorts keys (scores) in REVERSE order (Highest first)
		TreeMap<Integer, String> leaderboard = new TreeMap<>(Collections.reverseOrder());

		// 1. Adding scores (out of order)
		leaderboard.put(1500, "DragonSlayer");
		leaderboard.put(4200, "AceGamer");
		leaderboard.put(2300, "PixelKnight");
		leaderboard.put(800, "NewbieNode");

		// 2. The map is automatically sorted by key
		System.out.println("--- Current Leaderboard ---");
		for (Map.Entry<Integer, String> entry : leaderboard.entrySet()) {
			System.out.println(entry.getKey() + " pts: " + entry.getValue());
		}

		// 3. Navigational Power (Unique to TreeMap)
		System.out.println("\n--- Performance Insights ---");
		System.out.println("Top Player: " + leaderboard.firstEntry()); // Highest score
		System.out.println("Lowest Player: " + leaderboard.lastEntry()); // Lowest score

		// Find the player just below 2500 points
		System.out.println("Next below 2500: " + leaderboard.higherEntry(2500));
	}
}
