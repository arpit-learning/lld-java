package com.example.designPatterns.structuralDesignPatterns.adapterDesignPattern;

import com.example.designPatterns.structuralDesignPatterns.adapterDesignPattern.iciciBankAPI.ICICIBankAPI;

public class ICICIBankAPIAdapter implements BankAPIAdapter {
    private ICICIBankAPI iciciBankAPI;

    public ICICIBankAPIAdapter() {
        iciciBankAPI = new ICICIBankAPI();
    }

    private String generateUserToken(User user) {
        return "userTokenString";
    }

    @Override
    public double checkBalance(User user) {
        String userToken = generateUserToken(user);
        double bal = iciciBankAPI.checkBalance(userToken);
        return bal;
    }

    @Override
    public int doTransaction(User fromUser, User toUser, double amount) {
        String fromUserToken = generateUserToken(fromUser);
        String toUserToken = generateUserToken(toUser);
        int status = iciciBankAPI.transferMoney(fromUserToken, toUserToken, amount);
        return status;
    }

    @Override
    public boolean changePin(User user, int currentPin, int newPin) {
        return false;
    }
}
