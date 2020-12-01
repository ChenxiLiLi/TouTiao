package com.bytedance.toutiao.base;

import androidx.lifecycle.MutableLiveData;

import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.MsgFocusModel;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.SearchHotModel;
import com.bytedance.toutiao.bean.TopicModel;
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

    //获取资讯列表
    public MutableLiveData<Resource<List<NewsModel>>> listNews(String type) {
        MutableLiveData<Resource<List<NewsModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().listNews(type), liveData);
    }

    //获取单条资讯详情
    public MutableLiveData<Resource<NewsModel>> newsDetail(String id) {
        MutableLiveData<Resource<NewsModel>> liveData = new MutableLiveData<>();
        return observe(getApiService().newsDetail(id), liveData);
    }

    //获取信息模块关注列表
    public MutableLiveData<Resource<List<MsgFocusModel>>> getMsgFocus() {
        MutableLiveData<Resource<List<MsgFocusModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().getMsgFocus(), liveData);
    }

    //获取信息模块评论列表
    public MutableLiveData<Resource<List<MessageCommentModel>>> getMsgComments(String type) {
        MutableLiveData<Resource<List<MessageCommentModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().getMsgComments(type), liveData);
    }

    //获取搜索模块列表
    public MutableLiveData<Resource<List<SearchHotModel>>> getSearchHot(String type) {
        MutableLiveData<Resource<List<SearchHotModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().getSearchHot(type), liveData);
    }

    //获取帖子
    public MutableLiveData<Resource<List<PostDetailModel>>> getPostByEventId(String eventId) {
        MutableLiveData<Resource<List<PostDetailModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().getPostsByEventId(eventId), liveData);
    }

    //获取视频
    public MutableLiveData<Resource<List<VideoModel>>> getMyVideos(int id, String state) {
        MutableLiveData<Resource<List<VideoModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().getMyVideos(id, state), liveData);
    }

    //获取资讯
    public MutableLiveData<Resource<List<NewsModel>>> getMyInfos(int id, String state) {
        MutableLiveData<Resource<List<NewsModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().getMyInfos(id, state), liveData);
    }

    //获取话题
    public MutableLiveData<Resource<List<TopicModel>>> getMyTopics(int id) {
        MutableLiveData<Resource<List<TopicModel>>> liveData = new MutableLiveData<>();
        return observe(getApiService().getMyTopics(id), liveData);
    }


}
