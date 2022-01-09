package com.jaintravelagency.jaintravelagency.Models;

public class Fine {
    private String finedVehicleRegNo;
    private String finedEmpId;
    private String offense;
    private int finedAmount;


    public Fine(){
    }

    public Fine(String finedVehicleRegNo, String finedEmpId, String offense, int finedAmount) {
        this.finedVehicleRegNo = finedVehicleRegNo;
        this.finedEmpId = finedEmpId;
        this.offense = offense;
        this.finedAmount = finedAmount;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "finedVehicleRegNo='" + finedVehicleRegNo + '\'' +
                ", finedEmpId='" + finedEmpId + '\'' +
                ", offense='" + offense + '\'' +
                ", finedAmount=" + finedAmount +
                '}';
    }

    public String getFinedVehicleRegNo() {
        return finedVehicleRegNo;
    }

    public void setFinedVehicleRegNo(String finedVehicleRegNo) {
        this.finedVehicleRegNo = finedVehicleRegNo;
    }

    public String getFinedEmpId() {
        return finedEmpId;
    }

    public void setFinedEmpId(String finedEmpId) {
        this.finedEmpId = finedEmpId;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public int getFinedAmount() {
        return finedAmount;
    }

    public void setFinedAmount(int finedAmount) {
        this.finedAmount = finedAmount;
    }
}
