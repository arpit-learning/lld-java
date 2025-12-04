package com.example.lambdas;

public class Main {
    public static void main(String[] args) {
        // way 1: using separate runner class
        PrintRunner r1 = new PrintRunner();
        Thread t1 = new Thread(r1);
        t1.start();

        // way 2: using unnamed object
        Thread t2 = new Thread(new PrintRunner());
        t2.start();

        // way 3: using anonymous class
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, World! using anonymous class in Thread : " + Thread.currentThread().getName());
            }
        };
        Thread t3 = new Thread(r3);
        t3.start();

        // way 4: using unnamed object of anonymous class
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, World! using anonymous class in Thread : " + Thread.currentThread().getName());
            }
        });
        t4.start();

        // way 5: using lambda expression
        Runnable r5 = () -> {
            System.out.println("Hello, World! using lambda expression in Thread : " + Thread.currentThread().getName());
        };
        Thread t5 = new Thread(r5);
        t5.start();

        // way 6: using unnamed object of lambda expression
        Thread t6 = new Thread(() -> {
            System.out.println("Hello, World! using lambda expression in Thread : " + Thread.currentThread().getName());
        });
        t6.start();

        // way 7: using shortened lambda expression
        Runnable r7 = () -> System.out.println("Hello, World! using shortened lambda expression in Thread : " + Thread.currentThread().getName());
        Thread t7 = new Thread(r7);
        t7.start();

        // way 8: using unnamed object of shortened lambda expression
        Thread t8 = new Thread(() -> System.out.println("Hello, World! using shortened lambda expression in Thread : " + Thread.currentThread().getName()));
        t8.start();
    }
}
