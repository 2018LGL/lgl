package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Bookfile implements Serializable{
    private String fileId;

    private String realName;

    private String contentType;

    private String url;

    private Date updateDatetime;

    public Bookfile(String fileId, String realName, String contentType, String url, Date updateDatetime) {
        this.fileId = fileId;
        this.realName = realName;
        this.contentType = contentType;
        this.url = url;
        this.updateDatetime = updateDatetime;
    }

    public Bookfile() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}