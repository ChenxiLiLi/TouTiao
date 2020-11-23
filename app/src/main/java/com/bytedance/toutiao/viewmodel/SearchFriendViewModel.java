package com.bytedance.toutiao.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.SearchFriendModel;

import java.util.List;

public class SearchFriendViewModel extends BaseViewModel<RepositoryImpl> {
    public SearchFriendViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<Resource<List<SearchFriendModel>>> getSearchFriend(){
        return getRepository().getSearchFriend();
    }
}
