package com.jaintravelagency.jaintravelagency.Models;

public class VehicleDoc {

    private String regCertificateNo;
    private String pollutionCheckCertificateNo;
    private String expiryForPollutionCheckCertificate;
    private String currentInsuranceNo;

    public VehicleDoc(){

    }

    public VehicleDoc(String regCertificateNo, String pollutionCheckCertificateNo, String expiryForPollutionCheckCertificate, String currentInsuranceNo) {
        this.regCertificateNo = regCertificateNo;
        this.pollutionCheckCertificateNo = pollutionCheckCertificateNo;
        this.expiryForPollutionCheckCertificate = expiryForPollutionCheckCertificate;
        this.currentInsuranceNo = currentInsuranceNo;
    }

    @Override
    public String toString() {
        return "VehicleDoc{" +
                "regCertificateNo='" + regCertificateNo + '\'' +
                ", pollutionCheckCertificateNo='" + pollutionCheckCertificateNo + '\'' +
                ", expiryForPollutionCheckCertificate='" + expiryForPollutionCheckCertificate + '\'' +
                ", currentInsuranceNo='" + currentInsuranceNo + '\'' +
                '}';
    }

    public String getRegCertificateNo() {
        return regCertificateNo;
    }

    public void setRegCertificateNo(String regCertificateNo) {
        this.regCertificateNo = regCertificateNo;
    }

    public String getPollutionCheckCertificateNo() {
        return pollutionCheckCertificateNo;
    }

    public void setPollutionCheckCertificateNo(String pollutionCheckCertificateNo) {
        this.pollutionCheckCertificateNo = pollutionCheckCertificateNo;
    }

    public String getExpiryForPollutionCheckCertificate() {
        return expiryForPollutionCheckCertificate;
    }

    public void setExpiryForPollutionCheckCertificate(String expiryForPollutionCheckCertificate) {
        this.expiryForPollutionCheckCertificate = expiryForPollutionCheckCertificate;
    }

    public String getCurrentInsuranceNo() {
        return currentInsuranceNo;
    }

    public void setCurrentInsuranceNo(String currentInsuranceNo) {
        this.currentInsuranceNo = currentInsuranceNo;
    }
}
