package com.example.concurrency.executorExample;

public class PrintingNumbersRunner implements Runnable {
    private final int numberToPrint;

    public PrintingNumbersRunner(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println(numberToPrint + " using Thread: " + Thread.currentThread().getName());
    }
}
