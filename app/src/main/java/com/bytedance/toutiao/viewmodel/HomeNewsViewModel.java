package com.bytedance.toutiao.viewmodel;


import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.Resource;

import java.util.List;

/**
 * Data : 2020/10/30
 * Time : 16:46
 * Author : 刘朝阳
 */
public class HomeNewsViewModel extends BaseViewModel<RepositoryImpl> {


    private String TAG = "HomeNewsViewModel";

    public HomeNewsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<List<NewsModel>>> listNews(String type){
        if (type == null || type.trim().length() == 0) {
            Log.e(TAG, "type is null || type is ''");
        }
        //类型，1：主资讯列表，2：关注资讯列表，3：同城资讯列表
        switch (type) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
        }
        return null;
    }


    public LiveData<Resource<NewsModel>> newsDetail(String id){
        return null;
    }
}
