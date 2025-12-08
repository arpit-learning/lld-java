package com.example.concurrency.problems.ZeroOddEven;

import java.util.concurrent.Semaphore;

class IntConsumer {
    public void accept(int n) {
        System.out.print(n);
    }
}


public class ZeroOddEven {
    private final Semaphore semaZ, semaE, semaO;
    private final int n;
    private final IntConsumer printNumber;

    public ZeroOddEven(int n, IntConsumer printNumber) {
        this.n = n;
        semaZ = new Semaphore(1);
        semaE = new Semaphore(0);
        semaO = new Semaphore(0);
        this.printNumber = printNumber;
    }

    public static void main(String[] args) throws InterruptedException {
        IntConsumer printNumber = new IntConsumer();
        ZeroOddEven zeroOddEven = new ZeroOddEven(3, printNumber);

        Thread printZeroThread = new Thread(() -> {
            try {
                zeroOddEven.zero();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        printZeroThread.start();

        Thread printEvenThread = new Thread(() -> {
            try {
                zeroOddEven.even();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        printEvenThread.start();

        Thread printOddThread = new Thread(() -> {
            try {
                zeroOddEven.odd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        printOddThread.start();

        printZeroThread.join();
        printOddThread.join();
        printEvenThread.join();
    }

    public void zero() throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            semaZ.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                semaO.release();
            } else {
                semaE.release();
            }
        }
    }

    public void odd() throws InterruptedException {
        for (int i = 1; i <= this.n; i += 2) {
            semaO.acquire();
            printNumber.accept(i);
            semaZ.release();
        }
    }

    public void even() throws InterruptedException {
        for (int i = 2; i <= this.n; i += 2) {
            semaE.acquire();
            printNumber.accept(i);
            semaZ.release();
        }
    }
}