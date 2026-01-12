package com.example.designPatterns.structuralDesignPatterns.adapterDesignPattern.yesBankAPI;

public class YesBankAPI {
    public long getBalance(String username, String password) {
        return 1000;
    }

    public char doTransaction(String fromUsername, String toUsername, String fromUserPassword, double amount) {
        return 'Y'; // Y N I
    }

    public boolean changePin(String username, String password, int currentPin, int newPin) {
        return true;
    }
}
