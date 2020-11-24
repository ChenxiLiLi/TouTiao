package com.bytedance.toutiao.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.bytedance.toutiao.MyApplication;
import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.User;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyViewModel extends BaseViewModel<RepositoryImpl> {
    public MyViewModel(@NonNull Application application) {
        super(application);
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
