package com.example.concurrency.problems.fizzBuzz;

import java.util.concurrent.Semaphore;

public class FizzBuzz {
    public final int n;
    public Semaphore semaFizz, semaBuzz, semaFizzBuzz, semaNumber;

    public FizzBuzz(int n) {
        this.n = n;
        semaFizz = new Semaphore(0);
        semaBuzz = new Semaphore(0);
        semaFizzBuzz = new Semaphore(0);
        semaNumber = new Semaphore(1);
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread tFizz = new Thread(() -> {
            for (int i = 1; i <= fizzBuzz.n; i++) {
                if (i % 3 == 0 && i % 5 != 0) {
                    try {
                        fizzBuzz.semaFizz.acquire();
                        System.out.print("fizz" + " ");
                        fizzBuzz.releaseExpected(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread tBuzz = new Thread(() -> {
            for (int i = 1; i <= fizzBuzz.n; i++) {
                if (i % 3 != 0 && i % 5 == 0) {
                    try {
                        fizzBuzz.semaBuzz.acquire();
                        System.out.print("buzz" + " ");
                        fizzBuzz.releaseExpected(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread tFizzBuzz = new Thread(() -> {
            for (int i = 1; i <= fizzBuzz.n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    try {
                        fizzBuzz.semaFizzBuzz.acquire();
                        System.out.print("fizzbuzz" + " ");
                        fizzBuzz.releaseExpected(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread tNumber = new Thread(() -> {
            for (int i = 1; i <= fizzBuzz.n; i++) {
                if (i % 3 != 0 && i % 5 != 0) {
                    try {
                        fizzBuzz.semaNumber.acquire();
                        System.out.print(i + " ");
                        fizzBuzz.releaseExpected(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        tFizz.start();
        tBuzz.start();
        tFizzBuzz.start();
        tNumber.start();

        try {
            tFizz.join();
            tBuzz.join();
            tFizzBuzz.join();
            tNumber.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void releaseExpected(int i) {
        int next = i + 1; // Check the NEXT number
        if (next % 3 == 0 && next % 5 == 0) {
            semaFizzBuzz.release();
        } else if (next % 3 == 0) {
            semaFizz.release();
        } else if (next % 5 == 0) {
            semaBuzz.release();
        } else {
            semaNumber.release();
        }
    }
}
