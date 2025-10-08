package com.company.ArrayListExample;

import java.util.ArrayList;

public class ArrayListMain {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> colors = new ArrayList<>();

        // Add elements to the ArrayList
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        // Access elements by index
        System.out.println("First color: " + colors.get(0)); // Output: Red

        // Iterate through the ArrayList
        System.out.println("All colors:");
        for (String color : colors) {
            System.out.println(color);
        }

        // Modify an element
        colors.set(1, "Yellow"); // Change "Green" to "Yellow"
        System.out.println("After modification: " + colors);

        // Remove an element
        colors.remove("Blue");
        System.out.println("After removing Blue: " + colors);

        // Check the size
        System.out.println("Size of ArrayList: " + colors.size());
    }
}