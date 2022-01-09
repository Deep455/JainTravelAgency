package com.jaintravelagency.jaintravelagency.Models;

public class Employee {

    private String empId;
    private String name;
    private String panCardNo;
    private String drivingLicenseNo;
    private String aadharNo;
    private String phoneNo;
    private String address;
    private String dob;
    private String emergencyPhoneNo;
    private String role;
    private String password;

    public Employee() {
    }

    public Employee(String empId, String name, String panCardNo, String drivingLicenseNo, String aadharNo, String phoneNo, String address, String dob, String emergencyPhoneNo, String role, String password) {
        this.empId = empId;
        this.name = name;
        this.panCardNo = panCardNo;
        this.drivingLicenseNo = drivingLicenseNo;
        this.aadharNo = aadharNo;
        this.phoneNo = phoneNo;
        this.address = address;
        this.dob = dob;
        this.emergencyPhoneNo = emergencyPhoneNo;
        this.role = role;
        this.password =password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", panCardNo='" + panCardNo + '\'' +
                ", drivingLicenseNo='" + drivingLicenseNo + '\'' +
                ", aadharNo='" + aadharNo + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", emergencyPhoneNo='" + emergencyPhoneNo + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPanCardNo() {
        return panCardNo;
    }

    public void setPanCardNo(String panCardNo) {
        this.panCardNo = panCardNo;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmergencyPhoneNo() {
        return emergencyPhoneNo;
    }

    public void setEmergencyPhoneNo(String emergencyPhoneNo) {
        this.emergencyPhoneNo = emergencyPhoneNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
