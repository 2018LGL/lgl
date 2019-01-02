package com.zking.ssm.vo;

import com.zking.ssm.model.Bookfile;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class BookFileVo extends Bookfile{

    private Integer bookId;

    private MultipartFile img;

    public BookFileVo() {
    }

    public BookFileVo(Integer bookId, MultipartFile img) {
        this.bookId = bookId;
        this.img = img;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
