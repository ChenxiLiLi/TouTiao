package com.bytedance.toutiao.viewmodel;

import android.annotation.SuppressLint;
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
import com.bytedance.toutiao.bean.TopicModel;
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

    //id
    private int id;
    //用户名绑定
    public final ObservableField<String> userName = new ObservableField<>("");
    //昵称的绑定
    public final ObservableField<String> nickName = new ObservableField<>("");
    //关注数绑定
    public final ObservableField<String> focusNum = new ObservableField<>("");
    //粉丝数绑定
    public final ObservableField<String> fansNUm = new ObservableField<>("");
    //性别的绑定
    public final ObservableField<String> sex = new ObservableField<>("");
    //手机的绑定
    public final ObservableField<String> tel = new ObservableField<>("");
    //邮箱的绑定
    public final ObservableField<String> email = new ObservableField<>("");
    //简介的绑定
    public final ObservableField<String> introduction = new ObservableField<>("");

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void getUser(){
        MyApplication.getDb().userDao().getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(User user) {
                        Log.e("ttttest", "获取user");
                        setId(user.getId());
                        userName.set(user.getUsername());
                        nickName.set(user.getNickname());
                        sex.set(user.getSex());
                        focusNum.set(String.valueOf(user.getFocusNum()));
                        fansNUm.set(String.valueOf(user.getFansNum()));
                        tel.set(user.getPhoneNumber());
                        email.set(user.getEmail());
                        introduction.set(user.getIntroduction());
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e);
                    }
                });
    }

    //获取视频
    public LiveData<Resource<List<VideoModel>>> getMyVideos(String state){
        return getRepository().getMyVideos(getId(), state);
    }

    //获取资讯
    public LiveData<Resource<List<NewsModel>>> getMyInfos(String state){
        return getRepository().getMyInfos(getId(), state);
    }

    //获取话题
    public LiveData<Resource<List<TopicModel>>> getMyTopics(){
        return getRepository().getMyTopics(getId());
    }

    //修改个人信息
    public LiveData<Resource<String>> myUpdate(){
        return getRepository().myUpdate(getId(), nickName.get(), sex.get(), introduction.get());
    }


    public void localUpdate(){
        new Thread(){
            @Override
            public void run() {
                MyApplication.getDb().userDao().updateUser(id, nickName.get(), sex.get(), introduction.get());
                Log.e("update", "epdate");
            }
        }.start();


    }

    public void deleteUser(){
//        MyApplication.getDb().userDao().deleteUser(getId())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(Integer delete) {
//                        if(delete > 0){
//                            Log.e("ttttest", "修改user");
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println(e);
//                    }
//                });
                }


}
