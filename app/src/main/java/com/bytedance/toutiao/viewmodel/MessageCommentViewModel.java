package com.bytedance.toutiao.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.bytedance.toutiao.base.BaseViewModel;
import com.bytedance.toutiao.base.RepositoryImpl;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.Resource;

import java.util.List;

/*
public class MessageCommentViewModel extends BaseViewModel<RepositoryImpl> {
    public MessageCommentViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Resource<List<MessageCommentModel>>> getMsgComment(){

        Log.e("message", "getMsgComment");
        return getRepository().getMsgComments();
    }
}
*/
