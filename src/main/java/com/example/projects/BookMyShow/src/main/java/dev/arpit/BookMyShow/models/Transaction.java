package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.TransactionPaymentStatus;
import dev.arpit.BookMyShow.models.constants.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Transaction extends BaseModel {
    private double transactionAmount;
    @Enumerated(EnumType.ORDINAL)
    private TransactionPaymentStatus transactionStatus;
    private String referenceNumber;
    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public Transaction setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public TransactionPaymentStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Transaction setTransactionStatus(TransactionPaymentStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public Transaction setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Transaction setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }
}
