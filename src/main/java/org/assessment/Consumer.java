package org.assessment;

public class Consumer implements Runnable {
    private final BlockingQueue queue;
    private final int id;

    Consumer(BlockingQueue q, int id) {
        queue = q;
        this.id = id;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Consumer " + id + " processing " + queue.take());
                Thread.sleep(2000); // Simulate time taken to process an item
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
