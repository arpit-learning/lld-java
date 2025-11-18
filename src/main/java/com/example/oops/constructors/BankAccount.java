package com.example.oops.constructors;

public class BankAccount {
    public int accountBalance; // public access modifier - Can be accessible from anywhere.
    protected String customerId; // protected access modifier - Can be accessible by the child classes.
    String accountNumber; // default access modifier - Can be accessible only within the same package.
    private String accountHolderName; // private access modifier - Can be accessible only within the class.
    private int minBalanceRequired; // private access modifier

    // default constructor
    public BankAccount() {

    }

    // parameterized constructor
    public BankAccount(String aNumber, int aBalance, String aHolderName, String cId, int mBalanceRequired) {
        accountNumber = aNumber;
        accountBalance = aBalance;
        accountHolderName = aHolderName;
        customerId = cId;
        minBalanceRequired = mBalanceRequired;
    }

    // copy constructor - using the old object information to create the new object
    public BankAccount(BankAccount bankAccount) {
        accountNumber = bankAccount.accountNumber + "NEW";
        accountBalance = bankAccount.accountBalance + 1000;
        accountHolderName = bankAccount.accountHolderName;
        customerId = bankAccount.customerId;
        minBalanceRequired = bankAccount.minBalanceRequired;
    }

    int getAccountBalance() {
        return accountBalance;
    }

    String getAccountNumber() {
        return accountNumber;
    }

    public boolean isBelowMinBalance() {
        if (accountBalance < minBalanceRequired) {
            return true;
        } else {
            return false;
        }
    }

    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Balance: " + accountBalance);
        System.out.println("Account holder Name: " + accountHolderName);
        System.out.println("Customer Id: " + customerId);
    }
}
