package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.TransactionPaymentStatus;
import dev.arpit.BookMyShow.models.constants.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Transaction extends BaseModel {
    private int transactionAmount;
    @Enumerated(EnumType.ORDINAL)
    private TransactionPaymentStatus transactionPaymentStatus;
    private String referenceNumber;
    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public TransactionPaymentStatus getTransactionPaymentStatus() {
        return transactionPaymentStatus;
    }

    public void setTransactionPaymentStatus(TransactionPaymentStatus transactionPaymentStatus) {
        this.transactionPaymentStatus = transactionPaymentStatus;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
