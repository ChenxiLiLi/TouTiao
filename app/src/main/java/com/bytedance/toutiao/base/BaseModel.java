package com.bytedance.toutiao.base;

import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.bean.basebean.ResponseModel;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Data : 2020/10/28
 * Time : 16:38
 * Author : 刘朝阳
 */
public abstract class BaseModel {
    public LifecycleTransformer objectLifecycleTransformer;
    public ArrayList<String> onNetTags;


    public void setObjectLifecycleTransformer(LifecycleTransformer objectLifecycleTransformer) {
        this.objectLifecycleTransformer = objectLifecycleTransformer;
    }

    public void setOnNetTags(ArrayList<String> onNetTags) {
        this.onNetTags = onNetTags;
    }

    public <T> MutableLiveData<T> observe(Observable observable, final MutableLiveData<T> liveData) {
        observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer() {
                    @Override
                    public void accept(Object disposable1) throws Exception {
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                //.compose(objectLifecycleTransformer)
                .subscribe(new Consumer() {
                    @Override
                    public void accept(Object o) throws Exception {
                        liveData.postValue((T) Resource.response((ResponseModel<Object>) o));

                    }
                }, new Consumer() {
                    @Override
                    public void accept(Object throwable) throws Exception {
                        Throwable throwable1 = (Throwable) throwable;
                        System.out.println(throwable1);
                        liveData.postValue((T) Resource.error((Throwable) throwable));
                    }
                })
        ;

        return liveData;
    }
}
