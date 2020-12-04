package com.bytedance.toutiao.ui.user.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.databinding.ActivityUserInformationBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.viewmodel.LoginViewModel;
import com.bytedance.toutiao.viewmodel.MyViewModel;

public class UserInformationActivity extends BaseActivity<MyViewModel, ActivityUserInformationBinding>{

    @Override
    protected int getContentViewId() {
        return R.layout.activity_user_information;
    }

    @Override
    protected void processLogic() {
        binding.setViewModel(mViewModel);
        mViewModel.getUser();
    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (view.getId()){
                    case R.id.my_update:
                        intent = new Intent(UserInformationActivity.this, MyUpdateActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_back:
                        finish();
                        break;
                }
            }
        });
    }
}
