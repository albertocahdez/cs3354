package com.company.HashMapExample;

import java.util.HashMap;

public class HashMapMain {
    public static void main(String[] args) {
        // Create a HashMap to store student names and their grades
        HashMap<String, Integer> studentGrades = new HashMap<>();

        // Add key-value pairs to the HashMap
        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 92);
        studentGrades.put("Charlie", 78);

        // Print the entire HashMap
        System.out.println("Student Grades: " + studentGrades);

        // Access a value by key
        System.out.println("Bob's grade: " + studentGrades.get("Bob"));

        // Check if a key exists
        if (studentGrades.containsKey("Alice")) {
            System.out.println("Alice is in the map.");
        }

        // Remove a key-value pair
        studentGrades.remove("Charlie");
        System.out.println("After removing Charlie: " + studentGrades);

        // Iterate over keys and values
        System.out.println("All students and their grades:");
        for (String name : studentGrades.keySet()) {
            System.out.println(name + ": " + studentGrades.get(name));
        }
    }
}