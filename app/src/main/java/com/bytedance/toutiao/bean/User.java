package com.bytedance.toutiao.bean;

/**
 * Data : 2020/10/29
 * Time : 15:46
 * Author : 刘朝阳
 */
public class User {
    private int id;
    private String nickname;
    private String password;

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
}
