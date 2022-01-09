package com.jaintravelagency.jaintravelagency.Repository;

import com.jaintravelagency.jaintravelagency.Models.Payment;

public interface PaymentRepository {
    public void savePayment(Payment payment);
    public boolean paymentReceiptNoExists(String paymentReceiptNo);
    public Payment findPaymentByPaymentReceiptNo(String paymentReceiptNo);
}
