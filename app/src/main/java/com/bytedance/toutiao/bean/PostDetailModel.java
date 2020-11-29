package com.bytedance.toutiao.bean;

public class PostDetailModel {
    private String topicId;
    private String topicName;
    private String authorId;
    private String authorName;
    private String content;
    private String postId;
    private String publishTime;
    private String topicPostNum;
    private String topicReadNum;
    private String position;
    private String loveNum;
    private String commentNum;
    private boolean isLove;

    public boolean isLove() {
        return isLove;
    }

    public void setLove(boolean love) {
        isLove = love;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLoveNum() {
        return loveNum;
    }

    public void setLoveNum(String loveNum) {
        this.loveNum = loveNum;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getTopicPostNum() {
        return topicPostNum;
    }

    public void setTopicPostNum(String topicPostNum) {
        this.topicPostNum = topicPostNum;
    }

    public String getTopicReadNum() {
        return topicReadNum;
    }

    public void setTopicReadNum(String topicReadNum) {
        this.topicReadNum = topicReadNum;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }
}
