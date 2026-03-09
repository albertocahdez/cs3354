package edu.txst.mapExamples;

import java.util.IdentityHashMap;
import java.util.HashMap;
import java.util.Map;

public class IdentityMapExample {
	public static void main(String[] args) {
		// Create two separate String objects with the same content
		String key1 = new String("Active");
		String key2 = new String("Active");

		// 1. Standard HashMap Behavior (Value Equality)
		Map<String, String> standardMap = new HashMap<>();
		standardMap.put(key1, "Processor A");
		standardMap.put(key2, "Processor B"); // Overwrites key1 because "Active".equals("Active")

		// 2. IdentityHashMap Behavior (Reference Equality)
		Map<String, String> identityMap = new IdentityHashMap<>();
		identityMap.put(key1, "Processor A");
		identityMap.put(key2, "Processor B"); // Keeps both because key1 != key2 in memory

		System.out.println("Standard HashMap Size: " + standardMap.size()); // Result: 1
		System.out.println("IdentityHashMap Size: " + identityMap.size()); // Result: 2

		// Proving why it happened
		System.out.println("\nStandard Map Contents: " + standardMap);
		System.out.println("Identity Map Contents: " + identityMap);

		System.out.println("\nAre the keys == ? " + (key1 == key2)); // false
		System.out.println("Are the keys .equals()? " + key1.equals(key2)); // true
	}
}
