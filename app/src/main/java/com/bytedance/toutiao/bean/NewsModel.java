package com.bytedance.toutiao.bean;

public class NewsModel {
    private String newsId;
    private String title;
    private String content;
    private String tag;
    private String publishTime;
    private String contentAddress;

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getContentAddress() {
        return contentAddress;
    }

    public void setContentAddress(String contentAddress) {
        this.contentAddress = contentAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
