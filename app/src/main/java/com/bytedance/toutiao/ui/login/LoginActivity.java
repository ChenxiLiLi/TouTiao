package com.bytedance.toutiao.ui.login;


import androidx.lifecycle.Observer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;

import com.bytedance.toutiao.databinding.ActivityLoginBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.LoginViewModel;


public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding>  {


    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void processLogic() {

        binding.setViewModel(mViewModel);
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        if(sp.getString("username", null) != null){
            mViewModel.userName.set(sp.getString("username", null));
            mViewModel.password.set(sp.getString("password", null));
        }

    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.tv_register :
                        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.btn_login:
                        login();
                        break;
                    case R.id.iv_clear_username:
                        mViewModel.userName.set("");
                        break;
                }
            }
        });
    }



    private void login(){

        if(mViewModel.userName.get() == null || "".equals(mViewModel.userName.get()))
            ToastUtils.showToast("请输入用户名");
        else if(mViewModel.password.get() == null || "".equals(mViewModel.password.get()))
            ToastUtils.showToast("请输入密码");
        else {
            User user = new User();
            user.setNickname("吃瓜群众");
            user.setId(1);
            user.setSex("男");
            user.setEmail("234234234@qq.com");
            user.setUsername(mViewModel.userName.get());
            user.setPhoneNumber("23423432");
            user.setFocusNum(23);
            user.setFansNum(234);
            user.setIntroduction("你爱我是谁");
            SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
            sp.edit()
                    .putString("username", user.getUsername())
                    .putString("password", user.getPassword())
                    .apply();
            mViewModel.insertUser(user);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
//            mViewModel.login()
//                    .observe(LoginActivity.this, new Observer<Resource<User>>() {
//                        @Override
//                        public void onChanged(Resource<User> userResource) {
//                            System.out.println(userResource);
//                            if (userResource.state == 1) {
//                                Log.e("login", userResource.data.getUsername());
//                                SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
//                                sp.edit()
//                                        .putString("username", mViewModel.userName.get())
//                                        .putString("password", mViewModel.password.get())
//                                        .apply();
//                                mViewModel.insertUser(userResource.data);
//                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                startActivity(intent);
//                            }
//                        }
//                    });
        }
    }

}
