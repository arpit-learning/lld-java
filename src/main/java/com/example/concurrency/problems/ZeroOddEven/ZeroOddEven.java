package com.example.concurrency.problems.ZeroOddEven;

import java.util.concurrent.Semaphore;

public class ZeroOddEven {
    private final Semaphore semaZ, semaE, semaO;
    private final int n;
    private int no = 1;

    public ZeroOddEven(int n) {
        this.n = n;
        semaZ = new Semaphore(1);
        semaE = new Semaphore(0);
        semaO = new Semaphore(0);
    }

    public static void main(String[] args) throws InterruptedException {
        ZeroOddEven zeroOddEven = new ZeroOddEven(3);
        IntConsumer printNumber = new IntConsumer();

        for (int i = 0; i < 10; i++) {
            PrintZero printZero = new PrintZero(zeroOddEven, printNumber);
            Thread printZeroThread = new Thread(printZero);
            printZeroThread.start();
        }

        for (int i = 0; i < 10; i++) {
            PrintEven printEven = new PrintEven(zeroOddEven, printNumber);
            Thread printEvenThread = new Thread(printEven);
            printEvenThread.start();
        }

        for (int i = 0; i < 10; i++) {
            PrintOdd printOdd = new PrintOdd(zeroOddEven, printNumber);
            Thread printOddThread = new Thread(printOdd);
            printOddThread.start();
        }
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        semaZ.acquire();
        if (no <= n) {
            printNumber.accept(0);
        }
        if (no % 2 == 1) {
            semaO.release();
        } else {
            semaE.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        semaE.acquire();
        if (no <= n) {
            printNumber.accept(no);
            no += 1;
        }
        semaZ.release();
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        semaO.acquire();
        if (no <= n) {
            printNumber.accept(no);
            no += 1;
        }
        semaZ.release();
    }
}