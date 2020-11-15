package com.bytedance.toutiao.bean.basebean;

import android.util.Log;

import java.io.Serializable;

/**
 * Data : 2020/10/29
 * Time : 15:48
 * Author : 刘朝阳
 * 泛型类
 */
public class ResponseModel<T> implements Serializable {
    public static final int RESULT_SUCCESS = 0;

    private T data;
    private int errorCode;
    private String errorMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess(){
        return RESULT_SUCCESS == errorCode;
    }
}
