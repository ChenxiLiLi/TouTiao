package com.bytedance.toutiao.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class NewsModel implements Serializable {
    private String id;
    private String title;
    private String picUrl;
    private String newsUrl;
    private String content;
    private String tag;
    private Long readNum;
    private Long likeNum;
    private Long commentNum;
    private String cityId;
    private String eventId;
    private String remark;
    private String publishUser;
    private String publishTime;
    private String lastUser;
    private Date lastTime;
    private Integer deleteFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getReadNum() {
        return readNum;
    }

    public void setReadNum(Long readNum) {
        this.readNum = readNum;
    }

    public Long getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Long likeNum) {
        this.likeNum = likeNum;
    }

    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPublishUser() {
        return publishUser;
    }

    public void setPublishUser(String publishUser) {
        this.publishUser = publishUser;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsModel)) return false;
        NewsModel newsModel = (NewsModel) o;
        return id.equals(newsModel.id) &&
                Objects.equals(publishUser, newsModel.publishUser) &&
                Objects.equals(publishTime, newsModel.publishTime) &&
                Objects.equals(lastUser, newsModel.lastUser) &&
                Objects.equals(lastTime, newsModel.lastTime) &&
                Objects.equals(deleteFlag, newsModel.deleteFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", newsUrl='" + newsUrl + '\'' +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                ", readNum=" + readNum +
                ", likeNum=" + likeNum +
                ", commentNum=" + commentNum +
                ", cityId='" + cityId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", remark='" + remark + '\'' +
                ", publishUser='" + publishUser + '\'' +
                ", publishTime=" + publishTime +
                ", lastUser='" + lastUser + '\'' +
                ", lastTime=" + lastTime +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
