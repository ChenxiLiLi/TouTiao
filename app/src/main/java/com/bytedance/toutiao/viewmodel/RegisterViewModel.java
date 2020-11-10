package com.bytedance.toutiao.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;

import java.util.HashMap;

public class RegisterViewModel extends BaseViewModel<RepositoryImpl> {
    //用户名的绑定
    public final ObservableField<String> userName = new ObservableField<>("");
    //密码的绑定
    public ObservableField<String> password = new ObservableField<>("");

    public ObservableField<String> confirmPassword = new ObservableField<>("");

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<User>> register(){
        HashMap<String, String> map = new HashMap<>();
        map.put("username", userName.get());
        map.put("password", password.get());
        return getRepository().register(map);

    }

}
