package com.company.HashSetExample;

import java.util.HashSet;

public class HashSetMain {
    public static void main(String[] args) {
        // Create a HashSet of Strings
        HashSet<String> fruits = new HashSet<>();

        // Add elements to the HashSet
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicate, will not be added

        // Print the HashSet
        System.out.println("Fruits in the HashSet:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Check if an element exists
        if (fruits.contains("Banana")) {
            System.out.println("Banana is in the set.");
        }

        // Remove an element
        fruits.remove("Orange");
        System.out.println("After removing Orange: " + fruits);

        // Check the size
        System.out.println("Set size: " + fruits.size());
    }
}