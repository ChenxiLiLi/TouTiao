package com.bytedance.toutiao.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.MsgFocusModel;
import com.bytedance.toutiao.bean.Resource;

import java.util.List;

public class MsgFocusViewModel extends BaseViewModel<RepositoryImpl> {
    public MsgFocusViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<Resource<List<MsgFocusModel>>> getMsgFocus(){
        Log.e("message", "getMsgFocus");
        return getRepository().getMsgFocus();
    }
}
