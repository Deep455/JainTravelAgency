package com.jaintravelagency.jaintravelagency.Models;

public class Trip {
    private String tripNo;
    private String driverId;
    private int journeyDistance;
    private String customerId;
    private int fuelConsumed;
    private String vehicleRegNo;
    private String receiptNo;

    public Trip(){
    }

    public Trip(String tripNo, String driverId, int journeyDistance, String customerId, int fuelConsumed, String vehicleRegNo, String receiptNo) {
        this.tripNo = tripNo;
        this.driverId = driverId;
        this.journeyDistance = journeyDistance;
        this.customerId = customerId;
        this.fuelConsumed = fuelConsumed;
        this.vehicleRegNo = vehicleRegNo;
        this.receiptNo = receiptNo;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripNo='" + tripNo + '\'' +
                ", driverId='" + driverId + '\'' +
                ", journeyDistance=" + journeyDistance +
                ", customerId='" + customerId + '\'' +
                ", fuelConsumed=" + fuelConsumed +
                ", vehicleRegNo='" + vehicleRegNo + '\'' +
                ", receiptNo='" + receiptNo + '\'' +
                '}';
    }

    public String getTripNo() {
        return tripNo;
    }

    public void setTripNo(String tripNo) {
        this.tripNo = tripNo;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public int getJourneyDistance() {
        return journeyDistance;
    }

    public void setJourneyDistance(int journeyDistance) {
        this.journeyDistance = journeyDistance;
    }


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getFuelConsumed() {
        return fuelConsumed;
    }

    public void setFuelConsumed(int fuelConsumed) {
        this.fuelConsumed = fuelConsumed;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }
}
