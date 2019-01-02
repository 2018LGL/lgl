package com.zking.ssm.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@ToString
public class Book implements Serializable{

    public static interface group{
        interface add{}
        interface del{}
    }

    @NotNull(message = "书本编号不能为空",groups = {Book.group.del.class})
    private Integer id;

    @NotBlank(message = "书本名称不能为空",groups = {Book.group.add.class})
    private String bookname;

    @NotNull(message = "书本价格不能为空",groups = {Book.group.add.class})
    @Range(min=10,message = "书本价格不能小于10$",groups = {Book.group.add.class})
    private Float price;

    @JsonProperty("btype")
    private String booktype;

    @JsonIgnore
    private String photo;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Book(Integer id, String bookname, Float price, String booktype, String photo) {
        this.id = id;
        this.bookname = bookname;
        this.price = price;
        this.booktype = booktype;
        this.photo = photo;
    }

    public Book() {
        super();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
}