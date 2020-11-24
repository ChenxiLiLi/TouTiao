package com.bytedance.toutiao.bean;

public class SearchHotModel {
    private String eventId;
    private String eventTitle;
    private String eventReadNum;
    private String eventHotRanking;

    public SearchHotModel(String eventTitle, String eventReadNum, String eventHotRanking) {
        this.eventTitle = eventTitle;
        this.eventReadNum = eventReadNum;
        this.eventHotRanking = eventHotRanking;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventReadNum() {
        return eventReadNum;
    }

    public void setEventReadNum(String eventReadNum) {
        this.eventReadNum = eventReadNum;
    }

    public String getEventHotRanking() {
        return eventHotRanking;
    }

    public void setEventHotRanking(String eventHotRanking) {
        this.eventHotRanking = eventHotRanking;
    }
}
