package com.zking.ssm.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
public class New implements Serializable{
    private Integer newsId;

    private String title;

    private List<Category> news = new ArrayList<Category>();

    public New(Integer newsId, String title) {
        this.newsId = newsId;
        this.title = title;
    }

    public List<Category> getNews() {
        return news;
    }

    public void setNews(List<Category> news) {
        this.news = news;
    }

    public New() {
        super();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}