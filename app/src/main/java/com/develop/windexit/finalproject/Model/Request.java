package com.develop.windexit.finalproject.Model;

import java.util.List;

/**
 * Created by WINDEX IT on 25-Feb-18.
 */

public class Request {
    private String phone;
    private String name;
    private String address;
    private String total;
    private String status;
    private String comment;
    private String paymentState;
    private String latLan;
    private List<Order>foods;

    public Request() {
    }

    public Request(String phone, String name, String address, String total, String status, String comment, String paymentState, String latLan, List<Order> foods) {
        this.phone = phone;
        this.name = name;
        this.address = address;
        this.total = total;
        this.status = status;
        this.comment = comment;
        this.paymentState = paymentState;
        this.latLan = latLan;
        this.foods = foods;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }

    public String getLatLan() {
        return latLan;
    }

    public void setLatLan(String latLan) {
        this.latLan = latLan;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}
