package com.bytedance.toutiao.bean;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Data : 2020/10/29
 * Time : 15:46
 * Author : 刘朝阳
 */
@Entity
public class User {
    @PrimaryKey
    private int id;
    private String email;
    @ColumnInfo(name = "phone_number")
    private String phoneNumber;
    private String sex;
    private String username;
    private String nickname;
    private String password;
    private String introduction;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntroduction(){
        return introduction;
    }

    public void setIntroduction(String introduction){
        this.introduction = introduction;
    }
}
