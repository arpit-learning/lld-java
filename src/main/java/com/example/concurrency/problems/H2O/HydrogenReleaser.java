package com.example.concurrency.problems.H2O;

import java.util.concurrent.Semaphore;

public class HydrogenReleaser implements Runnable {
    Semaphore semaH, semaO;

    public HydrogenReleaser(Semaphore semaH, Semaphore semaO) {
        this.semaH = semaH;
        this.semaO = semaO;
    }

    @Override
    public void run() {
        try {
            semaH.acquire();
            System.out.print("H");
            if (semaO.availablePermits() == 0) semaO.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
