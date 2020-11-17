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


    public HomeNewsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<List<NewsModel>>> listNews(String type){
        if (type == null || type.trim().length() == 0) {
            //Log.e
        }
        return null;
    }


    public LiveData<Resource<NewsModel>> newsDetail(String id){
        return null;
    }
}
