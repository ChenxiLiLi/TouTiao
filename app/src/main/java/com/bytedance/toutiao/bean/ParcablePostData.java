package com.bytedance.toutiao.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcablePostData implements Parcelable {
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

    public ParcablePostData(PostDetailModel postDetailModel) {
        this.topicId = postDetailModel.getTopicId();
        this.topicName = postDetailModel.getTopicName();
        this.authorId = postDetailModel.getAuthorId();
        this.authorName = postDetailModel.getAuthorName();
        this.content = postDetailModel.getContent();
        this.postId = postDetailModel.getPostId();
        this.publishTime = postDetailModel.getPublishTime();
        this.topicPostNum = postDetailModel.getTopicPostNum();
        this.topicReadNum = postDetailModel.getTopicReadNum();
        this.position = postDetailModel.getPosition();
        this.loveNum = postDetailModel.getLoveNum();
        this.commentNum = postDetailModel.getCommentNum();
    }

    protected ParcablePostData(Parcel in) {
        topicId = in.readString();
        topicName = in.readString();
        authorId = in.readString();
        authorName = in.readString();
        content = in.readString();
        postId = in.readString();
        publishTime = in.readString();
        topicPostNum = in.readString();
        topicReadNum = in.readString();
        position = in.readString();
        loveNum = in.readString();
        commentNum = in.readString();
    }

    public static final Creator<ParcablePostData> CREATOR = new Creator<ParcablePostData>() {
        @Override
        public ParcablePostData createFromParcel(Parcel in) {
            return new ParcablePostData(in);
        }

        @Override
        public ParcablePostData[] newArray(int size) {
            return new ParcablePostData[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(topicId);
        parcel.writeString(topicName);
        parcel.writeString(authorId);
        parcel.writeString(authorName);
        parcel.writeString(content);
        parcel.writeString(postId);
        parcel.writeString(publishTime);
        parcel.writeString(topicPostNum);
        parcel.writeString(topicReadNum);
        parcel.writeString(position);
        parcel.writeString(loveNum);
        parcel.writeString(commentNum);
    }
}
