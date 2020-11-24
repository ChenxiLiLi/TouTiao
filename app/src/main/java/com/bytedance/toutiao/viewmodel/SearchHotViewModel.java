package com.bytedance.toutiao.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.SearchHotModel;

import java.util.List;

public class SearchHotViewModel extends BaseViewModel<RepositoryImpl> {
    public SearchHotViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Resource<List<SearchHotModel>>> getSearchHot(){
        return getRepository().getSearchHot();
    }
}
