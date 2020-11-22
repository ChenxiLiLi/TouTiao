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
public class NewsViewModel extends BaseViewModel<RepositoryImpl> {


    private String TAG = "NewsViewModel";

    public NewsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<List<NewsModel>>> listNews(String type){
        if (type == null || type.trim().length() == 0) {
            Log.e(TAG, "type is null || type is ''");
        }
        System.out.println("传入的参数为："+type);
        /*LiveData<Resource<List<NewsModel>>> res = null;
        //类型，1：主资讯列表，2：关注资讯列表，3：同城资讯列表
        switch (type) {
            case "1":
                res = getRepository().listNews("1");
                break;
            case "2":
                res =  getRepository().listNews("2");
                break;
            case "3":
                res = getRepository().listNews("3");
                break;
        }
        return res;*/

        return getRepository().listNews(type);
    }


    public LiveData<Resource<NewsModel>> newsDetail(String id){
        if (id == null || "".equals(id.trim())) {
            Log.e(TAG, "id is null || id is ''");
        }
        return getRepository().newsDetail(id);
    }
}
