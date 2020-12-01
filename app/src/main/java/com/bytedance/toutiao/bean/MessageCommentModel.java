package com.bytedance.toutiao.bean;

public class MessageCommentModel {
    private String msgCommentId;
    private String msgCommentUserId;
    private String msgCommentName;
    private String msgCommentUserAvater;
    private String msgCommentContent;
    private String msgCommentDate;
    private String msgCommentNewsType;
    private String loveNum;
    private String num;
    private String eventAvater;
    private String introduction;
    private boolean isLove = false;

    public MessageCommentModel(String msgCommentName, String num) {
        this.msgCommentName = msgCommentName;
        this.num = num;
    }

    public boolean isLove() {
        return isLove;
    }

    public void setLove(boolean love) {
        isLove = love;
    }

    public String getLoveNum() {
        return loveNum;
    }

    public void setLoveNum(String loveNum) {
        this.loveNum = loveNum;
    }

    public MessageCommentModel() {
    }

    public MessageCommentModel(String msgCommentId, String msgCommentUserId, String msgCommentName, String msgCommentUserAvater, String msgCommentContent, String msgCommentDate, String msgCommentNewsType, String loveNum, String num, String eventAvater, boolean isLove) {
        this.msgCommentId = msgCommentId;
        this.msgCommentUserId = msgCommentUserId;
        this.msgCommentName = msgCommentName;
        this.msgCommentUserAvater = msgCommentUserAvater;
        this.msgCommentContent = msgCommentContent;
        this.msgCommentDate = msgCommentDate;
        this.msgCommentNewsType = msgCommentNewsType;
        this.loveNum = loveNum;
        this.num = num;
        this.eventAvater = eventAvater;
        this.isLove = isLove;
    }

    public MessageCommentModel(String msgCommentId, String msgCommentUserId, String msgCommentName, String msgCommentUserAvater, String msgCommentContent, String msgCommentDate, String msgCommentNewsType) {
        this.msgCommentId = msgCommentId;
        this.msgCommentUserId = msgCommentUserId;
        this.msgCommentName = msgCommentName;
        this.msgCommentUserAvater = msgCommentUserAvater;
        this.msgCommentContent = msgCommentContent;
        this.msgCommentDate = msgCommentDate;
        this.msgCommentNewsType = msgCommentNewsType;
    }

    public MessageCommentModel(String msgCommentName) {
        this.msgCommentName = msgCommentName;
    }

    public MessageCommentModel(String msgCommentName, String msgCommentContent, String msgCommentDate) {
        this.msgCommentName = msgCommentName;
        this.msgCommentContent = msgCommentContent;
        this.msgCommentDate = msgCommentDate;
    }

    public String getMsgCommentId() {
        return msgCommentId;
    }

    public void setMsgCommentId(String msgCommentId) {
        this.msgCommentId = msgCommentId;
    }

    public String getMsgCommentUserId() {
        return msgCommentUserId;
    }

    public void setMsgCommentUserId(String msgCommentUserId) {
        this.msgCommentUserId = msgCommentUserId;
    }

    public String getMsgCommentName() {
        return msgCommentName;
    }

    public void setMsgCommentName(String msgCommentName) {
        this.msgCommentName = msgCommentName;
    }

    public String getMsgCommentUserAvater() {
        return msgCommentUserAvater;
    }

    public void setMsgCommentUserAvater(String msgCommentUserAvater) {
        this.msgCommentUserAvater = msgCommentUserAvater;
    }

    public String getMsgCommentContent() {
        return msgCommentContent;
    }

    public void setMsgCommentContent(String msgCommentContent) {
        this.msgCommentContent = msgCommentContent;
    }

    public String getMsgCommentDate() {
        return msgCommentDate;
    }

    public void setMsgCommentDate(String msgCommentDate) {
        this.msgCommentDate = msgCommentDate;
    }

    public String getMsgCommentNewsType() {
        return msgCommentNewsType;
    }

    public void setMsgCommentNewsType(String msgCommentNewsType) {
        this.msgCommentNewsType = msgCommentNewsType;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEventAvater() {
        return eventAvater;
    }

    public void setEventAvater(String eventAvater) {
        this.eventAvater = eventAvater;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
