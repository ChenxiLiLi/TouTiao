package com.bytedance.toutiao.viewmodel;

import android.app.Application;

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
    public ObservableField<String> userName = new ObservableField<>("");
    //密码的绑定
    public ObservableField<String> password = new ObservableField<>("");
    //用户名清除按钮的显示隐藏绑定
    public ObservableInt clearBtnVisibility = new ObservableInt();
    //封装一个界面发生改变的观察者
//    public UIChangeObservable uc = new UIChangeObservable();
//
//    public class UIChangeObservable {
//        //密码开关观察者
//        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<>();
//    }


    public LoginViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Resource<User>> login(HashMap<String, String> map ){
        return getRepository().login(map);

    }


}
