package com.bytedance.toutiao.ui.user.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityAccountManagementBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.MyViewModel;

public class AccountManagementActivity extends BaseActivity<MyViewModel, ActivityAccountManagementBinding>{

    @Override
    protected int getContentViewId() {
        return R.layout.activity_account_management;
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
                    case R.id.management_loginout:
                        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                        sp.edit().clear().apply();
                        mViewModel.deleteUser();
                        ToastUtils.showToast("退出登录成功");
                        intent = new Intent(AccountManagementActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_back:
                        intent = new Intent(AccountManagementActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_tel:
                        intent = new Intent(AccountManagementActivity.this, MyTelActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_email:
                        intent = new Intent(AccountManagementActivity.this, MyEmailActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.management_change_password:
                        intent = new Intent(AccountManagementActivity.this, ChangePasswordActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
