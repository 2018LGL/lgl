package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Btype implements Serializable{
    private String bname;
    private String bvalue;

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBvalue() {
        return bvalue;
    }

    public void setBvalue(String bvalue) {
        this.bvalue = bvalue;
    }

    public Btype(String bname, String bvalue) {
        this.bname = bname;
        this.bvalue = bvalue;
    }

    public Btype() {

    }
}
