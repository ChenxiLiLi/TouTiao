package com.bytedance.toutiao.viewmodel;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;

import com.bytedance.toutiao.MyApplication;
import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.utils.AppUtils;
import com.bytedance.toutiao.utils.ToastUtils;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.bytedance.toutiao.MyApplication.getDb;

/**
 * Data : 2020/10/30
 * Time : 16:46
 * Author : 刘朝阳
 */
public class LoginViewModel extends BaseViewModel<RepositoryImpl> {

    private String TAG = "LoginViewModel";

    //用户名的绑定
    public final ObservableField<String> userName = new ObservableField<>("");
    //密码的绑定
    public final ObservableField<String> password = new ObservableField<>("");

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Resource<User>> login(){
        HashMap<String, String> map = new HashMap<>();
        map.put("username", userName.get());
        map.put("password", password.get());
        return getRepository().login(map);

    }


    public void insertUser(final User user){
        Callable<List<Long>> callable = new Callable<List<Long>>() {
            @Override
            public List<Long> call() throws Exception {
                return getDb().userDao().insertAll(user);
            }
        };
        Single.fromCallable(callable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Long>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Long> longs) {
                        Log.i(TAG, String.format("onSuccess: insert success id = %s", Arrays.toString(longs.toArray())));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: insert error", e);
                    }
                });
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
                        Log.e(TAG, user.getUsername());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }

}
