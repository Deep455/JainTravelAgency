package com.jaintravelagency.jaintravelagency.Models;

public class Vehicle {
    private String regNo;
    private String available;
    private int distanceTravelled;
    private int buyingPrice;
    private String handlerId;
    private int purchaseYear;
    private String company;
    private String color;
    private String model;
    private int seatingCapacity;

    public Vehicle(){

    }

    public Vehicle(String regNo, String available, int distanceTravelled, int buyingPrice, String handlerId, int purchaseYear, String company, String color, String model, int seatingCapacity) {
        this.regNo = regNo;
        this.available = available;
        this.distanceTravelled = distanceTravelled;
        this.buyingPrice = buyingPrice;
        this.handlerId = handlerId;
        this.purchaseYear = purchaseYear;
        this.company = company;
        this.color = color;
        this.model = model;
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "regNo='" + regNo + '\'' +
                ", available='" + available + '\'' +
                ", distanceTravelled=" + distanceTravelled +
                ", buyingPrice=" + buyingPrice +
                ", handlerId='" + handlerId + '\'' +
                ", purchaseYear=" + purchaseYear +
                ", company='" + company + '\'' +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                '}';
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public String getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public void setPurchaseYear(int purchaseYear) {
        this.purchaseYear = purchaseYear;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }
}
