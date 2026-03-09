package edu.txst.mapExamples;

import java.util.Hashtable;
import java.util.Enumeration;

public class HashtableExample {
    public static void main(String[] args) {
        // Create a Hashtable
        Hashtable<Integer, String> employeeDir = new Hashtable<>();

        // 1. Adding elements
        employeeDir.put(101, "Alice");
        employeeDir.put(102, "Bob");
        employeeDir.put(103, "Charlie");

        // 2. Accessing a value
        String name = employeeDir.get(102);
        System.out.println("Employee 102 is: " + name);

        // 3. Thread-safe check and update
        if (employeeDir.containsKey(101)) {
            System.out.println("Updating Alice's record...");
            employeeDir.put(101, "Alice Cooper");
        }

        // 4. Iterating using the legacy Enumeration (specific to Hashtable/Vector)
        System.out.println("\n--- Full Directory ---");
        Enumeration<Integer> keys = employeeDir.keys();
        while (keys.hasMoreElements()) {
            Integer id = keys.nextElement();
            System.out.println("ID: " + id + " | Name: " + employeeDir.get(id));
        }
        
        // 5. Important constraint: No nulls allowed!
        try {
            employeeDir.put(104, null); 
        } catch (NullPointerException e) {
            System.out.println("\nError: Hashtable does not allow null keys or values.");
        }
    }
}