package com.jaintravelagency.jaintravelagency.Models;

public class VehicleInsuranceDetails {
    private String insuranceNo;
    private String insuranceProvider;
    private String startingDate;
    private String expiryDate;
    private String currentStatus;
    private int amountInsuranced;
    private String insuranceType;
    private String benificiary;

    public VehicleInsuranceDetails(){
    }

    public VehicleInsuranceDetails(String insuranceNo, String insuranceProvider, String startingDate, String expiryDate, String currentStatus, int amountInsuranced, String insuranceType, String benificiary) {
        this.insuranceNo = insuranceNo;
        this.insuranceProvider = insuranceProvider;
        this.startingDate = startingDate;
        this.expiryDate = expiryDate;
        this.currentStatus = currentStatus;
        this.amountInsuranced = amountInsuranced;
        this.insuranceType = insuranceType;
        this.benificiary = benificiary;
    }

    @Override
    public String toString() {
        return "VehicleInsuranceDetails{" +
                "insuranceNo='" + insuranceNo + '\'' +
                ", insuranceProvider='" + insuranceProvider + '\'' +
                ", startingDate='" + startingDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", amountInsuranced=" + amountInsuranced +
                ", insuranceType='" + insuranceType + '\'' +
                ", benificiary='" + benificiary + '\'' +
                '}';
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
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

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getAmountInsuranced() {
        return amountInsuranced;
    }

    public void setAmountInsuranced(int amountInsuranced) {
        this.amountInsuranced = amountInsuranced;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getBenificiary() {
        return benificiary;
    }

    public void setBenificiary(String benificiary) {
        this.benificiary = benificiary;
    }

}
