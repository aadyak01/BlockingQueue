package org.assessment;

public class Producer implements Runnable {
private final BlockingQueue queue;

        Producer(BlockingQueue q) {
        queue = q;
        }

public void run() {
            try
            {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Producing " + i);
                    queue.put(i);
                    Thread.sleep(1000); // Simulate time taken to produce an item
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
}