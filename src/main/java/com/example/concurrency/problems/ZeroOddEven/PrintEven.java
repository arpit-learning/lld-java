package com.example.concurrency.problems.ZeroOddEven;

public class PrintEven implements Runnable {
    private final ZeroOddEven zeroOddEven;
    private final IntConsumer intConsumer;

    public PrintEven(ZeroOddEven zeroOddEven, IntConsumer intConsumer) {
        this.zeroOddEven = zeroOddEven;
        this.intConsumer = intConsumer;
    }

    @Override
    public void run() {
        try {
            zeroOddEven.even(intConsumer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
