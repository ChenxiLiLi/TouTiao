package com.bytedance.toutiao.ui.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityChangePasswordBinding;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.MyViewModel;

public class ChangePasswordActivity extends BaseActivity<MyViewModel, ActivityChangePasswordBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_change_password;
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
                switch (view.getId()){
                    case R.id.btn_save:
                        if(mViewModel.password.get() == null)
                            ToastUtils.showToast("请输入密码");
                        else if(mViewModel.confirmPassword.get() == null)
                            ToastUtils.showToast("请确认密码");
                        else if(!mViewModel.password.get().equals(mViewModel.confirmPassword.get()))
                            ToastUtils.showToast("密码不一致");
                        else {
                            mViewModel.updatePassword().observe(ChangePasswordActivity.this, new Observer<Resource<String>>() {
                                @Override
                                public void onChanged(Resource<String> stringResource) {
                                    Log.e("update password", stringResource.state +"");
                                    ToastUtils.showToast("修改成功");
                                    finish();
                                }
                            });
                        }break;
                }
            }
        });
    }
}
