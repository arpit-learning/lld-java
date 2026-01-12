package com.example.designPatterns.structuralDesignPatterns.adapterDesignPattern;

import com.example.designPatterns.structuralDesignPatterns.adapterDesignPattern.yesBankAPI.YesBankAPI;

public class YesBankAPIAdapter implements BankAPIAdapter {
    private YesBankAPI yesBankAPI;

    public YesBankAPIAdapter() {
        yesBankAPI = new YesBankAPI();
    }

    @Override
    public double checkBalance(User user) {
        long bal = yesBankAPI.getBalance(user.getName(), user.getPassword());
        return (double) bal;
    }

    @Override
    public int doTransaction(User fromUser, User toUser, double amount) {
        char status = yesBankAPI.doTransaction(fromUser.getName(), toUser.getName(), fromUser.getPassword(), amount);
        return switch (status) {
            case 'Y' -> 1;
            case 'N' -> 0;
            default -> 2;
        };
    }

    @Override
    public boolean changePin(User user, int currentPin, int newPin) {
        return false;
    }
}
