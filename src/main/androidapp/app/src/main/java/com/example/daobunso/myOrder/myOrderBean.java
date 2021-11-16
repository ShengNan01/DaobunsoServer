package com.example.daobunso.myOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class myOrderBean {


    Integer orderId;

    Date orderDate;

    Integer memberId;

    String address;

    String phone;

    String contact;

    String timeForGarbage;

    Integer sum;

    String payType;

    String taxIDnumber;

    String companyTitle;

    String scheduleGarbage;

    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public myOrderBean(Integer orderId, Date orderDate , Integer sum) {
        this.orderId = orderId;

        Date d= null;
        try {
            d = format.parse(format.format(orderDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.orderDate =d;

        this.sum = sum;
    }

    public myOrderBean(Integer orderId, String contact, Integer sum) {
        this.orderId = orderId;
        this.contact = contact;
        this.sum = sum;
    }

    public myOrderBean() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}