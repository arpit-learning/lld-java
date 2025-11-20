package com.example.concurrency.basicExample;

public class PrintRunner implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello, World! is running with: " + Thread.currentThread().getName());
    }
}
