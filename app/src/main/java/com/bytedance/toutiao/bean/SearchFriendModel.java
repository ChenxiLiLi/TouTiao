package com.bytedance.toutiao.bean;

public class SearchFriendModel {
    private String eventId;
    private String eventTitle;
    private String eventReadNum;
    private String eventFriendRanking;

    public SearchFriendModel(String eventId, String eventTitle, String eventReadNum, String eventFriendRanking) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventReadNum = eventReadNum;
        this.eventFriendRanking = eventFriendRanking;
    }

    public SearchFriendModel(String eventTitle, String eventReadNum, String eventFriendRanking) {
        this.eventTitle = eventTitle;
        this.eventReadNum = eventReadNum;
        this.eventFriendRanking = eventFriendRanking;
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

    public String getEventFriendRanking() {
        return eventFriendRanking;
    }

    public void setEventFriendRanking(String eventFriendRanking) {
        this.eventFriendRanking = eventFriendRanking;
    }
}
