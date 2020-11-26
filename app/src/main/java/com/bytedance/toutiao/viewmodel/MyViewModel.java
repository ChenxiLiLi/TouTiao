package com.bytedance.toutiao.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.bytedance.toutiao.MyApplication;
import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.bean.VideoModel;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyViewModel extends BaseViewModel<RepositoryImpl> {
    public MyViewModel(@NonNull Application application) {
        super(application);
    }

    //昵称的绑定
    public final ObservableField<String> nickName = new ObservableField<>("");
    //简介的绑定
    public final ObservableField<String> introduction = new ObservableField<>("");

    //获取视频
    public LiveData<Resource<List<VideoModel>>> getMyVideos(String id, String state){
        return getRepository().getMyVideos(id, state);
    }

    //获取资讯
    public LiveData<Resource<List<NewsModel>>> getMyInfos(String id, String state){
        return getRepository().getMyInfos(id, state);
    }

    public void getUser(final int id){
        MyApplication.getDb().userDao().findById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(User user) {
                        Log.e("userinfo", user.getUsername());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
