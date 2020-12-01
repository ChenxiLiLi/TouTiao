package com.bytedance.toutiao.ui.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityMyTelBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.MyViewModel;

public class MyTelActivity extends BaseActivity<MyViewModel, ActivityMyTelBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_tel;
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
                        if(mViewModel.tel.get() == null){
                            ToastUtils.showToast("邮箱不可为空");
                        }else {
                            mViewModel.myTel().observe(MyTelActivity.this, new Observer<Resource<String>>() {
                                @Override
                                public void onChanged(Resource<String> stringResource) {
                                    Log.e("update", stringResource.state +"");
                                    mViewModel.updateTel();
                                }
                            });
                            intent = new Intent(MyTelActivity.this, AccountManagementActivity.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
        });
    }
}
