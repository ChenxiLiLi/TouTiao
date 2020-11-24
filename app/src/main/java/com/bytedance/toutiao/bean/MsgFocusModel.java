package com.bytedance.toutiao.bean;

public class MsgFocusModel {
    private String msgFocusId;
    private String msgFocusUserId;
    private String msgFocusEventId;
    private String msgFocusEventPhoto;
    private String msgFocusEventName;
    private String msgFocusReadNum;

    public MsgFocusModel(String msgFocusId, String msgFocusUserId, String msgFocusEventId, String msgFocusEventPhoto, String msgFocusEventName, String msgFocusReadNum) {
        this.msgFocusId = msgFocusId;
        this.msgFocusUserId = msgFocusUserId;
        this.msgFocusEventId = msgFocusEventId;
        this.msgFocusEventPhoto = msgFocusEventPhoto;
        this.msgFocusEventName = msgFocusEventName;
        this.msgFocusReadNum = msgFocusReadNum;
    }

    public MsgFocusModel(String msgFocusEventName, String msgFocusReadNum) {
        this.msgFocusEventName = msgFocusEventName;
        this.msgFocusReadNum = msgFocusReadNum;
    }

    public String getMsgFocusId() {
        return msgFocusId;
    }

    public void setMsgFocusId(String msgFocusId) {
        this.msgFocusId = msgFocusId;
    }

    public String getMsgFocusUserId() {
        return msgFocusUserId;
    }

    public void setMsgFocusUserId(String msgFocusUserId) {
        this.msgFocusUserId = msgFocusUserId;
    }

    public String getMsgFocusEventId() {
        return msgFocusEventId;
    }

    public void setMsgFocusEventId(String msgFocusEventId) {
        this.msgFocusEventId = msgFocusEventId;
    }

    public String getMsgFocusEventPhoto() {
        return msgFocusEventPhoto;
    }

    public void setMsgFocusEventPhoto(String msgFocusEventPhoto) {
        this.msgFocusEventPhoto = msgFocusEventPhoto;
    }

    public String getMsgFocusEventName() {
        return msgFocusEventName;
    }

    public void setMsgFocusEventName(String msgFocusEventName) {
        this.msgFocusEventName = msgFocusEventName;
    }

    public String getMsgFocusReadNum() {
        return msgFocusReadNum;
    }

    public void setMsgFocusReadNum(String msgFocusReadNum) {
        this.msgFocusReadNum = msgFocusReadNum;
    }
}
