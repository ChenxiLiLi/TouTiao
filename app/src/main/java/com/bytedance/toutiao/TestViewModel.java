package com.bytedance.toutiao;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;

import java.util.HashMap;

/**
 * Data : 2020/10/29
 * Time : 13:25
 * Author : 刘朝阳
 */
public class TestViewModel extends BaseViewModel<RepositoryImpl> {
    public TestViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getText(){
        MutableLiveData<String> liveData = new MutableLiveData<>();
        liveData.setValue("daladaladalada dala dala dadadalala");
        return liveData;
    }

    public LiveData<Resource<User>> login(HashMap<String, String> map ){
        return getRepository().login(map);

    }


}
