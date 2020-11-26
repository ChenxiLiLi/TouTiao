package com.bytedance.toutiao.ui.user.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityAccountManagementBinding;
import com.bytedance.toutiao.utils.ToastUtils;

public class AccountManagementActivity extends BaseActivity<NormalViewModel, ActivityAccountManagementBinding>{

    @Override
    protected int getContentViewId() {
        return R.layout.activity_account_management;
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {
        binding.managementLoginout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                sp.edit().clear().apply();
                ToastUtils.showToast("退出登录成功");
            }
        });
    }
}
