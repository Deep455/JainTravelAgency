package com.jaintravelagency.jaintravelagency.Services;

import com.jaintravelagency.jaintravelagency.Models.Payment;
import com.jaintravelagency.jaintravelagency.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.savePayment(payment);
    }

    @Override
    public boolean paymentReceiptNoExists(String paymentReceiptNo) {
        return paymentRepository.paymentReceiptNoExists(paymentReceiptNo);
    }

    @Override
    public Payment findPaymentByPaymentReceiptNo(String paymentReceiptNo) {
        return paymentRepository.findPaymentByPaymentReceiptNo(paymentReceiptNo);
    }

}
