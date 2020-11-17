package com.bytedance.toutiao.ui.user.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityPublishInformationBinding;

public class PublishInformationActivity extends BaseActivity<NormalViewModel, ActivityPublishInformationBinding> implements TextWatcher {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_publish_information;
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_information);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}

