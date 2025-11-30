package com.example.concurrency.problems.ZeroOddEven;

public class PrintOdd implements Runnable {
    private final ZeroOddEven zeroOddEven;
    private final IntConsumer intConsumer;

    public PrintOdd(ZeroOddEven zeroOddEven, IntConsumer intConsumer) {
        this.zeroOddEven = zeroOddEven;
        this.intConsumer = intConsumer;
    }

    @Override
    public void run() {
        try {
            zeroOddEven.odd(intConsumer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
