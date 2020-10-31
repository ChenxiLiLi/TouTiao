package com.bytedance.toutiao.base;

import android.app.Application;

import androidx.annotation.NonNull;

/**
 * Data : 2020/10/28
 * Time : 14:59
 * Author : 刘朝阳
 * 用来代替viewmodel
 */
public class NormalViewModel extends BaseViewModel {

    public NormalViewModel(@NonNull Application application) {
        super(application);
    }
}
