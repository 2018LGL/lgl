package com.zking.ssm.model;


import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
public class Customer implements Serializable{
    private Integer customerId;

    private String customerName;

    private List<Order> lst=new ArrayList<Order>();

    public Customer(Integer customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public List<Order> getLst() {
        return lst;
    }

    public void setLst(List<Order> lst) {
        this.lst = lst;
    }

    public Customer() {
        super();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}