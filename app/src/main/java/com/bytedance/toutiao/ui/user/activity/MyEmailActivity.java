package com.bytedance.toutiao.ui.user.activity;

import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityMyEmailBinding;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.MyViewModel;

public class MyEmailActivity extends BaseActivity<MyViewModel, ActivityMyEmailBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_email;
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
                    case R.id.tel_save:
                        if(mViewModel.email.get() == null){
                            ToastUtils.showToast("邮箱不可为空");
                        }else {
                            mViewModel.myEmail().observe(MyEmailActivity.this, new Observer<Resource<String>>() {
                                @Override
                                public void onChanged(Resource<String> stringResource) {
                                    Log.e("update", stringResource.state +"");
                                    mViewModel.updateEmail();
                                }
                            });
                            intent = new Intent(MyEmailActivity.this, AccountManagementActivity.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
        });
    }
}
