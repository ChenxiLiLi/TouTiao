package com.bytedance.toutiao.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.VideoModel;

import java.util.List;

public class VideoViewModel extends BaseViewModel<RepositoryImpl> {

    //


    public VideoViewModel(@NonNull Application application) {
        super(application);
    }


    //获取推荐视频
    public LiveData<Resource<List<VideoModel>>> getRecommentVideo(){
        return getRepository().getRecommentVideos();
    }

    //获取事件帖子列表
    public LiveData<Resource<List<PostDetailModel>>> getPostByEventId(String eventId){
        return getRepository().getPostByEventId(eventId);
    }

}
