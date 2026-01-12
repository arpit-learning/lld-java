package com.example.designPatterns.structuralDesignPatterns.adapterDesignPattern;

public class PhonePe {
    BankAPIAdapter bankAPIAdapter;

    public PhonePe() {
        bankAPIAdapter = new ICICIBankAPIAdapter();
    }

    public double checkBalance(User user) {
        double d = bankAPIAdapter.checkBalance(user);
        System.out.println("Balance: " + d);
        return d;
    }

    public void transferMoney(User fromUser, User toUser, double amount) {
        if (bankAPIAdapter.checkBalance(fromUser) < amount) {
            System.out.println("Insufficient balance in source account");
            return;
        }

        int status = bankAPIAdapter.doTransaction(fromUser, toUser, amount);
        switch (status) {
            case 0:
                System.out.println("Transaction failed");
                break;
            case 1:
                System.out.println("Insufficient successful");
                break;
            case 2:
                System.out.println("Transaction in progress");
                break;
        }
    }
}
