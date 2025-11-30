package com.example.concurrency.synchronisation.mutex;

import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable {
    private final int offset;
    private Counter c;
    private ReentrantLock mutex;

    public Adder(Counter c, int offset, ReentrantLock mutex) {
        this.c = c;
        this.offset = offset;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        mutex.lock();
        for (int i = 0; i < 10000; i++) {
            this.c.setValue(this.c.getValue() + this.offset);
        }
        mutex.unlock();
    }
}
