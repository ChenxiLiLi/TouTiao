package com.bytedance.toutiao.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.bean.basebean.ResponseModel;
import com.bytedance.toutiao.databinding.ActivityLoginBinding;
import com.bytedance.toutiao.retrofit.RetrofitApiService;
import com.bytedance.toutiao.retrofit.RetrofitManager;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.viewmodel.LoginViewModel;

import java.util.HashMap;

import io.reactivex.Observable;

public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding> implements TextWatcher {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_login:
                        login();
                        break;
                }
            }
        });
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    private void login(){
        String userName = binding.etUsername.getText().toString();
        String password = binding.etPassword.getText().toString();
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "learnabout");
        map.put("password", "123456");
        mViewModel.login(map)
                .observe(LoginActivity.this, new Observer<Resource<User>>() {
                    @Override
                    public void onChanged(Resource<User> userResource) {
                        Log.e("Login main", userResource.state + "");
                        if(userResource.state == 1){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });

    }
}
