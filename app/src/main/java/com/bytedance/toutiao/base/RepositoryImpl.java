package com.bytedance.toutiao.base;

import androidx.lifecycle.MutableLiveData;

import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;

import java.util.HashMap;

import static com.bytedance.toutiao.retrofit.RetrofitManager.getApiService;

/**
 * Data : 2020/10/28
 * Time : 16:38
 * Author : 刘朝阳
 */
public class RepositoryImpl extends BaseModel {
    public MutableLiveData<Resource<User>> login(HashMap<String, String> map) {
        MutableLiveData<Resource<User>> liveData = new MutableLiveData<>();
        return observe(getApiService().login(map), liveData);
    }
}
