package com.example.concurrency.synchronisation.semaphore;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Queue<Item> store = new LinkedList<>();
        int maxStore = 5;
        Semaphore semaProducer = new Semaphore(maxStore);
        Semaphore semaConsumer = new Semaphore(0);

        Producer p1 = new Producer(store, maxStore, "P1", semaProducer, semaConsumer);
        Producer p2 = new Producer(store, maxStore, "P2", semaProducer, semaConsumer);
        Producer p3 = new Producer(store, maxStore, "P3", semaProducer, semaConsumer);
        Producer p4 = new Producer(store, maxStore, "P4", semaProducer, semaConsumer);
        Producer p5 = new Producer(store, maxStore, "P5", semaProducer, semaConsumer);

        Consumer c1 = new Consumer(store, maxStore, "C1", semaProducer, semaConsumer);
        Consumer c2 = new Consumer(store, maxStore, "C2", semaProducer, semaConsumer);
        Consumer c3 = new Consumer(store, maxStore, "C3", semaProducer, semaConsumer);
        Consumer c4 = new Consumer(store, maxStore, "C4", semaProducer, semaConsumer);
        Consumer c5 = new Consumer(store, maxStore, "C5", semaProducer, semaConsumer);

        Thread tp1 = new Thread(p1);
        tp1.start();
        Thread tc1 = new Thread(c1);
        tc1.start();
        Thread tp2 = new Thread(p2);
        tp2.start();
        Thread tc2 = new Thread(c2);
        tc2.start();
        Thread tp3 = new Thread(p3);
        tp3.start();
        Thread tc3 = new Thread(c3);
        tc3.start();
        Thread tp4 = new Thread(p4);
        tp4.start();
        Thread tc4 = new Thread(c4);
        tc4.start();
        Thread tp5 = new Thread(p5);
        tp5.start();
        Thread tc5 = new Thread(c5);
        tc5.start();
    }
}
