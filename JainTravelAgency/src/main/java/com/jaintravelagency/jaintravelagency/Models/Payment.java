package com.jaintravelagency.jaintravelagency.Models;

public class Payment {
    private String paymentReceiptNo;
    private String dateOfPayment;
    private int amountPaid;
    private String tripNo;
    private int taxes;
    private int fines;

    public Payment(){

    }

    public Payment(String paymentReceiptNo, String dateOfPayment, int amountPaid, String tripNo, int taxes, int fines) {
        this.paymentReceiptNo = paymentReceiptNo;
        this.dateOfPayment = dateOfPayment;
        this.amountPaid = amountPaid;
        this.tripNo = tripNo;
        this.taxes = taxes;
        this.fines = fines;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentReceiptNo='" + paymentReceiptNo + '\'' +
                ", dateOfPayment='" + dateOfPayment + '\'' +
                ", amountPaid=" + amountPaid +
                ", tripNo='" + tripNo + '\'' +
                ", taxes=" + taxes +
                ", fines=" + fines +
                '}';
    }

    public String getPaymentReceiptNo() {
        return paymentReceiptNo;
    }

    public void setPaymentReceiptNo(String paymentReceiptNo) {
        this.paymentReceiptNo = paymentReceiptNo;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getTripNo() {
        return tripNo;
    }

    public void setTripNo(String tripNo) {
        this.tripNo = tripNo;
    }

    public int getTaxes() {
        return taxes;
    }

    public void setTaxes(int taxes) {
        this.taxes = taxes;
    }

    public int getFines() {
        return fines;
    }

    public void setFines(int fines) {
        this.fines = fines;
    }
}
