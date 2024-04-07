package org.assessment;

public class BlockingQueue {
    private final Object[] items;
    private int putIndex, takeIndex, count;

    public BlockingQueue(int capacity) {
        items = new Object[capacity];
    }

    public synchronized void put(Object x) throws InterruptedException {
        while (count == items.length) {
            wait(); // Wait if the queue is full
        }
        items[putIndex] = x;
        if (++putIndex == items.length) putIndex = 0;
        ++count;
        notifyAll(); // Notify other threads that an item has been added
    }

    public synchronized Object take() throws InterruptedException {
        while (count == 0) {
            wait(); // Wait if the queue is empty
        }
        Object x = items[takeIndex];
        if (++takeIndex == items.length) takeIndex = 0;
        --count;
        notifyAll(); // Notify other threads that an item has been removed
        return x;
    }
}