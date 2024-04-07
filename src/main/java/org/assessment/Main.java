package org.assessment;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        BlockingQueue queue = new BlockingQueue(1);

        // Start one producer thread
        new Thread(new Producer(queue)).start();

        // Start five consumer threads
        for (int i = 0; i < 5; i++) {
            new Thread(new Consumer(queue, i)).start();
        }
    }
}