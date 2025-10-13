package com.company.PriorityQueueExample;

import java.util.PriorityQueue;

public class PriorityQueueMain {
    public static void main(String[] args) {
        // Create a PriorityQueue of integers
        PriorityQueue<Integer> numbers = new PriorityQueue<Integer>();

        // Add elements to the PriorityQueue
        numbers.add(42);
        numbers.add(15);
        numbers.add(27);
        numbers.add(8);

        // Print the PriorityQueue (note: order is not guaranteed)
        System.out.println("PriorityQueue contents: " + numbers);

        // Access and remove elements in priority order
        System.out.println("Polling elements in priority order:");
        while (!numbers.isEmpty()) {
            System.out.println(numbers.poll()); // Retrieves and removes the smallest element
        }
    }
}