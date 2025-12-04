package com.example.lambdas;

public class PrintRunner implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello, World! using separate class in Thread : " + Thread.currentThread().getName());
    }
}
