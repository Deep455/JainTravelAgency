package com.jaintravelagency.jaintravelagency.Models;

public class EmployeeInsuranceDetails {

    private String insuranceNo;
    private String currentStatus;
    private String insuranceProvider;
    private String startingDate;
    private String expiryDate;
    private String insuranceType;
    private int amountInsured;
    private String beneficiary;

    public EmployeeInsuranceDetails(){
    }

    public EmployeeInsuranceDetails(String insuranceNo, String currentStatus, String insuranceProvider, String startingDate, String expiryDate, String insuranceType, int amountInsured, String beneficiary) {
        this.insuranceNo = insuranceNo;
        this.currentStatus = currentStatus;
        this.insuranceProvider = insuranceProvider;
        this.startingDate = startingDate;
        this.expiryDate = expiryDate;
        this.insuranceType = insuranceType;
        this.amountInsured = amountInsured;
        this.beneficiary = beneficiary;
    }

    @Override
    public String toString() {
        return "EmployeeInsuranceDetails{" +
                "insuranceNo='" + insuranceNo + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", insuranceProvider='" + insuranceProvider + '\'' +
                ", startingDate='" + startingDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", insuranceType='" + insuranceType + '\'' +
                ", amountInsured=" + amountInsured +
                ", beneficiary='" + beneficiary + '\'' +
                '}';
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public int getAmountInsured() {
        return amountInsured;
    }

    public void setAmountInsured(int amountInsured) {
        this.amountInsured = amountInsured;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }
}
