package com.bytedance.toutiao.base;

import androidx.lifecycle.MutableLiveData;

import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.bean.VideoModel;

import java.util.HashMap;
import java.util.List;

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

    public MutableLiveData<Resource<User>> register(HashMap<String, String> map) {
        MutableLiveData<Resource<User>> liveData = new MutableLiveData<>();
        return observe(getApiService().register(map), liveData);
    }

    //获取推荐视频列表
    public MutableLiveData<Resource<List<VideoModel>>> getRecommentVideos() {
        MutableLiveData<Resource<List<VideoModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().getRecommentVideos(), liveData);
    }

    //获取全部资讯列表
    public MutableLiveData<Resource<List<NewsModel>>> listNews() {
        MutableLiveData<Resource<List<NewsModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().listNews(), liveData);
    }

    //获取关注资讯列表
    public MutableLiveData<Resource<List<NewsModel>>> followNews() {
        MutableLiveData<Resource<List<NewsModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().followNews(), liveData);
    }

    //获取同城资讯列表
    public MutableLiveData<Resource<List<NewsModel>>> sameCityNews() {
        MutableLiveData<Resource<List<NewsModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().sameCityNews(), liveData);
    }

    //获取单条资讯详情
    public MutableLiveData<Resource<NewsModel>> newsDetail() {
        MutableLiveData<Resource<NewsModel>> liveData = new MutableLiveData<>();
        return observe(getApiService().newsDetail(), liveData);
    }

}
