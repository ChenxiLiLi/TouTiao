package com.bytedance.toutiao.ui.login;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

import androidx.lifecycle.Observer;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.databinding.ActivityRegisterBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.RegisterViewModel;

public class RegisterActivity extends BaseActivity<RegisterViewModel, ActivityRegisterBinding> {


    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected void processLogic() {
        binding.setViewModel(mViewModel);
    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.iv_clear_username:
//                        mViewModel.userName.set("");
                        break;
                    case R.id.btn_register:
                        register();
                        break;
                }
            }
        });
    }

    public void register(){
        if(mViewModel.userName.get() == null)
            ToastUtils.showToast("请输入用户名");
        else if(mViewModel.password.get() == null)
            ToastUtils.showToast("请输入密码");
        else if(mViewModel.confirmPassword.get() == null)
            ToastUtils.showToast("请确认密码");
        else if(!mViewModel.password.get().equals(mViewModel.confirmPassword.get()))
            ToastUtils.showToast("密码不一致");
        else{
            mViewModel.register()
                    .observe(this, new Observer<Resource<User>>() {
                        @Override
                        public void onChanged(Resource<User> userResource) {
                            if (userResource.state == 1) {
                                SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                                sp.edit()
                                        .putString("username", mViewModel.userName.get())
                                        .putString("password", mViewModel.password.get())
                                        .apply();
                                ToastUtils.showToast("登录成功");
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    });
        }


    }


}
