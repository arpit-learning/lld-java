package com.example.oops.polymorphism;

public class Calculator {

//    These methods are not user-friendly as user need to call different functions with respect to different parameters type.
//    public void addIntInt(int a, int b) {
//        System.out.println(a + b);
//    }
//
//    public void addIntDouble(int a, double b) {
//        System.out.println(a + b);
//    }
//
//    public void addDoubleInt(double a, int b) {
//        System.out.println(a + b);
//    }
//
//    public void addDoubleDouble(double a, double b) {
//        System.out.println(a + b);
//    }

    //    To make this user-friendly we can use polymorphism using method overloading.
    public void add(int a, int b) {
        System.out.println(a + b);
    }

    public void add(int a, double b) {
        System.out.println(a + b);
    }

    public void add(double a, int b) {
        System.out.println(a + b);
    }

    public void add(double a, double b) {
        System.out.println(a + b);
    }
}
