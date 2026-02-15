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

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public TransactionPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(TransactionPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
