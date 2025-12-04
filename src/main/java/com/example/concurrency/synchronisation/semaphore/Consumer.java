package com.example.concurrency.synchronisation.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    Queue<Item> store;
    int maxSize;
    String name;
    Semaphore semaProducer;
    Semaphore semaConsumer;

    public Consumer(Queue<Item> store, int maxSize, String name, Semaphore semaProducer, Semaphore semaConsumer) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaConsumer.acquire();
                Item item = store.remove();
                System.out.println(item.getName() + " bought by " + name);
                semaProducer.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Store size : " + store.size());
        }
    }
}
