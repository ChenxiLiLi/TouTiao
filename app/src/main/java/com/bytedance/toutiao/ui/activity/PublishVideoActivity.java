package com.bytedance.toutiao.ui.activity;

import android.text.Editable;
import android.text.TextWatcher;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityPublishVideoBinding;

public class PublishVideoActivity extends BaseActivity<NormalViewModel, ActivityPublishVideoBinding> implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_publish_video;
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {

    }
}