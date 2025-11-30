package com.example.concurrency.synchronisation.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    Queue<Item> store;
    int maxSize;
    String name;
    Semaphore semaProducer;
    Semaphore semaConsumer;

    public Producer(Queue<Item> store, int maxSize, String name, Semaphore semaProducer, Semaphore semaConsumer) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            try {
                semaProducer.acquire();
                store.add(new Item("item " + i++ + " of " + name, name));
                semaConsumer.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Store size : " + store.size());
        }
    }
}
