package dev.arpit.BookMyShow.services.adapters;

import dev.arpit.BookMyShow.external.RazorpayApi;
import dev.arpit.BookMyShow.models.*;
import dev.arpit.BookMyShow.models.constants.TransactionPaymentStatus;
import dev.arpit.BookMyShow.models.constants.TransactionType;
import dev.arpit.BookMyShow.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RazorpayAdapter implements PaymentAdapter {
    private RazorpayApi razorpayApi;
    @Autowired
    private TransactionRepository transactionRepository;

    public RazorpayAdapter() {
        this.razorpayApi = new RazorpayApi();
    }

    public RazorpayAdapter(RazorpayApi razorpayApi) {
        this.razorpayApi = razorpayApi;
    }

    @Override
    public Payment makePayment(double amount) {
        String statusStr = razorpayApi.processPayment(amount);

        Payment payment = new Payment();
        List<Transaction> transactions = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            Transaction transaction = new Transaction();
            transaction.setTransactionAmount(amount / 2)
                    .setTransactionType(TransactionType.UPI)
                    .setReferenceNumber("UPI-" + i)
                    .setTransactionStatus(TransactionPaymentStatus.SUCCESS);
            transaction = transactionRepository.save(transaction);
            transactions.add(transaction);
        }
        payment.setTransactions(transactions)
                .setPaymentStatus(TransactionPaymentStatus.valueOf(statusStr))
                .setTotalAmount(amount);
        return payment;
    }
}
