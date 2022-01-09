package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Payment;

public interface PaymentService {
    public void savePayment(Payment payment);
    public boolean paymentReceiptNoExists(String paymentReceiptNo);
    public Payment findPaymentByPaymentReceiptNo(String paymentReceiptNo);
}
