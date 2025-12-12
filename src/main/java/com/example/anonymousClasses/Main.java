package com.example.anonymousClasses;

public class Main {
    public static void main(String[] args) {
        Vehicle fourWheeler = new FourWheeler();
        Vehicle twoWheeler = new Vehicle() {
            public void run() {
                System.out.println("Run Two wheeler");
            }

            public void start() {
                System.out.println("Start Two wheeler");
            }

            public void brake() {
                System.out.println("Brake Two wheeler");
            }
        };

        fourWheeler.start();
        fourWheeler.run();
        fourWheeler.brake();

        twoWheeler.start();
        twoWheeler.run();
        twoWheeler.brake();

        // anonymous class will also work with abstract classes if we implement the abstract method
        Demo anonymousAbsObj = new Demo() {
            public void absDoSomething() {
                System.out.println("Abstract do something");
            }
        };

        anonymousAbsObj.absDoSomething();
        anonymousAbsObj.doSomething();
    }
}
