package com.example.concurrency.problems.H2O;

import java.util.concurrent.Semaphore;

public class H2O {
    Semaphore semaH, semaO;

    public H2O() {
        semaH = new Semaphore(2);
        semaO = new Semaphore(0);
    }

    public static void main(String[] args) {
        String s = "OOHHHH";
        Semaphore semaH, semaO;
        semaH = new Semaphore(2);
        semaO = new Semaphore(0);

        for (char c : s.toCharArray()) {
            if (c == 'H') {
                HydrogenReleaser hydrogenReleaser = new HydrogenReleaser(semaH, semaO);
                Thread thread = new Thread(hydrogenReleaser);
                thread.start();
            } else if (c == 'O') {
                OxygenReleaser oxygenReleaser = new OxygenReleaser(semaH, semaO);
                Thread thread = new Thread(oxygenReleaser);
                thread.start();
            }
        }
    }
}
