package com.jaintravelagency.jaintravelagency.Models;

public class Emergency {

    private String phoneNo;
    private String forWhom;
    private String name;
    private String relation;

    public Emergency(){

    }

    public Emergency(String phoneNo, String forWhom, String name, String relation) {
        this.phoneNo = phoneNo;
        this.forWhom = forWhom;
        this.name = name;
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "Emergency{" +
                "phoneNo='" + phoneNo + '\'' +
                ", forWhom='" + forWhom + '\'' +
                ", name='" + name + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getForWhom() {
        return forWhom;
    }

    public void setForWhom(String forWhom) {
        this.forWhom = forWhom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
