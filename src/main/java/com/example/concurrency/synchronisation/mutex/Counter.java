package com.example.concurrency.synchronisation.mutex;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);
        ReentrantLock mutex = new ReentrantLock();

        Adder a = new Adder(counter, 1, mutex);
        Subtractor s = new Subtractor(counter, 1, mutex);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(s);
        System.out.println(counter.getValue());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getValue());
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
