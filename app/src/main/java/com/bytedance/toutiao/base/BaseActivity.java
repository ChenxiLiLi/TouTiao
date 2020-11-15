package com.bytedance.toutiao.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;

import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.utils.ToastUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Data : 2020/10/27
 * Time : 22:06
 * Author : 刘朝阳
 */
//ViewDataBinding 是所有DataBinding的父类
public abstract class BaseActivity<VM extends BaseViewModel, VDB extends ViewDataBinding>
        extends AppCompatActivity
         {
    //获取当前activity布局文件
    protected abstract int getContentViewId();
    //处理逻辑业务
    protected abstract void processLogic();
    protected abstract void setListener();
    protected VM mViewModel;
    protected VDB binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        //初始化binding
        binding = DataBindingUtil.setContentView(this, getContentViewId());
        //给binding加上感知生命周期，AppCompatActivity就是lifeOwner
        binding.setLifecycleOwner(this);
//        创建ViewModel;
        createViewModel();

        processLogic();
        setListener();
    }

    public void createViewModel() {
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
        mViewModel = (VM) ViewModelProviders.of(this).get(modelClass);
        }
    }

    public abstract class OnCallback<T> implements Resource.OnHandleCallback<T> {
                 @Override
                 public void onLoading(String msg) {
                 }

                 @Override
                 public void onError(Throwable throwable) {
                 }

                 @Override
                 public void onFailure(String msg) {
                     ToastUtils.showToast(msg);
                 }

                 @Override
                 public void onCompleted() {

                 }

                 @Override
                 public void onProgress(int precent, long total) {
                 }
             }
}

