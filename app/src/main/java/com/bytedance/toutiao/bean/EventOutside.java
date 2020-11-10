package com.bytedance.toutiao.bean;

public class EventOutside {
    private String title;
    private String date;
    private int enteric;

    public EventOutside(String title, String date, int enteric) {
        this.title = title;
        this.date = date;
        this.enteric = enteric;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public int getEnteric() {
        return enteric;
    }


}
