package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Order implements Serializable{
    private Integer orderId;

    private String orderNo;

    private Integer cid;

    private Customer customer;

    public Order(Integer orderId, String orderNo, Integer cid) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.cid = cid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}