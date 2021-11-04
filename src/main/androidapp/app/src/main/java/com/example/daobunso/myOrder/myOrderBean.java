package com.example.daobunso.myOrder;

public class myOrderBean {

    int orederId;
    String type;
    String contact;
    String phone;

    public myOrderBean() {
    }

    public myOrderBean(int orederId, String type, String contact, String phone) {
        this.orederId = orederId;
        this.type = type;
        this.contact = contact;
        this.phone = phone;
    }

    public int getOrederId() {
        return orederId;
    }

    public void setOrederId(int orederId) {
        this.orederId = orederId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}