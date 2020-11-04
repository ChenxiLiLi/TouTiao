package com.bytedance.toutiao.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;

import java.util.HashMap;

/**
 * Data : 2020/10/30
 * Time : 16:46
 * Author : 刘朝阳
 */
public class LoginViewModel extends BaseViewModel<RepositoryImpl> {

    //用户名的绑定
    public final ObservableField<String> userName = new ObservableField<>("");
    //密码的绑定
    public ObservableField<String> password = new ObservableField<>("");
    //用户名清除按钮的显示隐藏绑定


    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<User>> login(){
        HashMap<String, String> map = new HashMap<>();
        map.put("username", userName.get());
        map.put("password", password.get());
        Log.e("username", userName.get());
        return getRepository().login(map);

    }



}
