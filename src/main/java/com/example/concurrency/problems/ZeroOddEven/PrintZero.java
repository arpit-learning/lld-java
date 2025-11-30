package com.example.concurrency.problems.ZeroOddEven;

public class PrintZero implements Runnable {
    private final ZeroOddEven zeroOddEven;
    private final IntConsumer intConsumer;

    public PrintZero(ZeroOddEven zeroOddEven, IntConsumer intConsumer) {
        this.zeroOddEven = zeroOddEven;
        this.intConsumer = intConsumer;
    }

    @Override
    public void run() {
        try {
            zeroOddEven.zero(intConsumer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
