package edu.txst.queueExamples;

import java.util.PriorityQueue;
import java.util.Comparator;

public class ERQueueExample {
	public static void main(String[] args) {
		// We want the HIGHEST severity (largest number) to come out first.
		// By default, PriorityQueue is a Min-Heap (smallest first),
		// so we use a custom Comparator for a Max-Heap.
		PriorityQueue<Patient> erQueue =
				new PriorityQueue<>(Comparator.comparingInt((Patient p) -> p.severity).reversed());

		// Patients arrive in this order
		erQueue.add(new Patient("John Doe", 2));
		erQueue.add(new Patient("Jane Smith", 5)); // Critical!
		erQueue.add(new Patient("Bob Brown", 1));
		erQueue.add(new Patient("Alice White", 4));

		System.out.println("Processing Patients based on Priority:");
		while (!erQueue.isEmpty()) {
			// poll() retrieves and removes the head of the queue
			System.out.println("Treating: " + erQueue.poll());
		}
	}
}
