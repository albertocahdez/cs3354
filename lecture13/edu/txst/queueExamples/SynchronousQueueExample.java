package edu.txst.queueExamples;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {
	public static void main(String[] args) {
		SynchronousQueue<String> handoff = new SynchronousQueue<>();

		// Producer Thread: The Delivery Driver
		Thread driver = new Thread(() -> {
			try {
				String packageItem = "Fresh Pizza";
				System.out.println("[Driver] Arrived with: " + packageItem);

				// This will BLOCK until the customer calls take()
				handoff.put(packageItem);

				System.out.println("[Driver] Package handed over successfully!");
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		// Consumer Thread: The Customer
		Thread customer = new Thread(() -> {
			try {
				System.out.println("[Customer] Leaving house to pick up delivery...");
				Thread.sleep(3000); // Customer takes 3 seconds to arrive

				// This will BLOCK until the driver calls put()
				String received = handoff.take();

				System.out.println("[Customer] Received: " + received);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		driver.start();
		customer.start();
	}
}
