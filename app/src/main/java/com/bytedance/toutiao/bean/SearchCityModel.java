package com.bytedance.toutiao.bean;

public class SearchCityModel {
    private String eventId;
    private String eventTitle;
    private String eventReadNum;
    private String eventCityRanking;

    public SearchCityModel(String eventId, String eventTitle, String eventReadNum, String eventCityRanking) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventReadNum = eventReadNum;
        this.eventCityRanking = eventCityRanking;
    }

    public SearchCityModel(String eventTitle, String eventReadNum, String eventCityRanking) {
        this.eventTitle = eventTitle;
        this.eventReadNum = eventReadNum;
        this.eventCityRanking = eventCityRanking;
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

    public String getEventCityRanking() {
        return eventCityRanking;
    }

    public void setEventCityRanking(String eventCityRanking) {
        this.eventCityRanking = eventCityRanking;
    }
}
