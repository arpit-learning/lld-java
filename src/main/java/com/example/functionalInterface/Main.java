package com.example.functionalInterface;

public class Main {
    public static void main(String[] args) {
        // Instructor with single-line implementation

        // Instructor implementation with Anonymous class
        Instructor<String> i1 = new Instructor<String>() {
            @Override
            public void teach(int numberOfStudents, String topic) {
                System.out.println("Teaching " + numberOfStudents + " students of " + topic);
            }
        };
        i1.teach(100, "LLD");

        // Instructor implementation with Lambda
        Instructor<String> i2 = (int numberOfStudents, String topic) -> {
            System.out.println("Teaching " + numberOfStudents + " students of " + topic);
        };
        i2.teach(100, "LLD");

        // Instructor implementation with Lambda, with lesser code
        Instructor<String> i3 = (x, y) -> // ideally keep the variable names same here as in the interface - (numberOfStudents, topic)
                System.out.println("Teaching " + x + " students of " + y);
        i3.teach(100, "LLD");

        // Instructor with multi-line implementation

        // Instructor implementation with Anonymous class
        Instructor<String> i4 = new Instructor<String>() {
            public void teach(int numberOfStudents, String topic) {
                System.out.println("Instructor will take a test");
                System.out.println("Instructor will take a viva");
                System.out.println("Teaching " + numberOfStudents + " students of " + topic);
            }
        };
        i4.teach(100, "LLD");

        // Instructor implementation with Lambda
        Instructor<String> i5 = (numberOfStudents, topic) -> {
            System.out.println("Instructor will take a test");
            System.out.println("Instructor will take a viva");
            System.out.println("Teaching " + numberOfStudents + " students of " + topic);
        };
        i5.teach(100, "LLD");


        // Calculator with multi-line implementation with anonymous class
        Calculator multiplier = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                int result = a * b;
                System.out.println(result);
                return result;
            }

            ;
        };
        int result = multiplier.calculate(10, 15);

        // Calculator with multi-line implementation with lambda
        Calculator multiplier2 = (a, b) -> {
            int r = a * b;
            System.out.println(r);
            return r;
        };
        multiplier2.calculate(10, 15);

        // Calculator with single-line implementation with anonymous class
        Calculator adder = new Calculator() {
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Answer " + adder.calculate(10, 15));

        // Calculator with single-line implementation with lambda
        Calculator adder2 = (a, b) -> a + b;
        System.out.println("Answer " + adder2.calculate(10, 15));

    }
}
