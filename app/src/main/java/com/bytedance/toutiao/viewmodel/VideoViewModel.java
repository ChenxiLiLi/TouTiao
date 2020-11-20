package com.bytedance.toutiao.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.VideoModel;

import java.util.List;

public class VideoViewModel extends BaseViewModel<RepositoryImpl> {

    //

    public VideoViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Resource<List<VideoModel>>> getRecommentVideo(){
        return getRepository().getRecommentVideos();
    }


}
