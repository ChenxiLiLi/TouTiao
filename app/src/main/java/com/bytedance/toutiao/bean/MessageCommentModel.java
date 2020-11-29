package com.bytedance.toutiao.bean;

public class MessageCommentModel {
    private String msgCommentId;
    private String msgCommentUserId;
    private String msgCommentUserName;
    private String msgCommentUserAvater;
    private String msgCommentContent;
    private String msgCommentDate;
    private String msgCommentNewsType;

    public MessageCommentModel(String msgCommentId, String msgCommentUserId, String msgCommentUserName, String msgCommentUserAvater, String msgCommentContent, String msgCommentDate, String msgCommentNewsType) {
        this.msgCommentId = msgCommentId;
        this.msgCommentUserId = msgCommentUserId;
        this.msgCommentUserName = msgCommentUserName;
        this.msgCommentUserAvater = msgCommentUserAvater;
        this.msgCommentContent = msgCommentContent;
        this.msgCommentDate = msgCommentDate;
        this.msgCommentNewsType = msgCommentNewsType;
    }

    public MessageCommentModel(String msgCommentUserName) {
        this.msgCommentUserName = msgCommentUserName;
    }

    public MessageCommentModel(String msgCommentUserName, String msgCommentContent, String msgCommentDate) {
        this.msgCommentUserName = msgCommentUserName;
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

    public String getMsgCommentUserName() {
        return msgCommentUserName;
    }

    public void setMsgCommentUserName(String msgCommentUserName) {
        this.msgCommentUserName = msgCommentUserName;
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
}
