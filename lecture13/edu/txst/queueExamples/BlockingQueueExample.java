package edu.txst.queueExamples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // Create a queue that can hold at most 3 elements
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Producing: " + i);
                    queue.put(i); // Blocks if the queue is full
                    Thread.sleep(500); // Mimic work
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    Integer take = queue.take(); // Blocks if the queue is empty
                    System.out.println("Consumed: " + take);
                    Thread.sleep(2000); // Consumer is slower than Producer
                    if (take == 5)
                        break; // Stop after last item
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
