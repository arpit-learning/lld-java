package com.example.concurrency.problems.H2O;

import java.util.concurrent.Semaphore;

public class OxygenReleaser implements Runnable {
    Semaphore semaH, semaO;

    public OxygenReleaser(Semaphore semaH, Semaphore semaO) {
        this.semaH = semaH;
        this.semaO = semaO;
    }

    @Override
    public void run() {
        try {
            semaO.acquire();
            System.out.print("O");
            semaH.release(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
