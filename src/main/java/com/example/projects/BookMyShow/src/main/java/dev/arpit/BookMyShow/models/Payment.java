package dev.arpit.BookMyShow.models;

import dev.arpit.BookMyShow.models.constants.TransactionPaymentStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Payment extends BaseModel {
    @OneToMany
    @JoinColumn(name = "payment_id")
    private List<Transaction> transactions;
    @Enumerated(EnumType.ORDINAL)
    private TransactionPaymentStatus paymentStatus;
    private double totalAmount;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Payment setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public TransactionPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public Payment setPaymentStatus(TransactionPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Payment setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }
}
