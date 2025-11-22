package com.example.concurrency.basicExample;

public class Main {
    public static void main(String[] args) {
        PrintRunner pr = new PrintRunner();
        Thread th = new Thread(pr);
        th.start();
        System.out.println("Hello, World! is running with: " + Thread.currentThread().getName());

        for (int i = 1; i <= 100; i++) {
            Thread noTh = new Thread(new PrintingNumbersRunner(i));
            noTh.start();
        }
    }
}
