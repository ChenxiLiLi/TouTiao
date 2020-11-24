package com.bytedance.toutiao.ui.user.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.databinding.ActivityUserInformationBinding;
import com.bytedance.toutiao.viewmodel.MyViewModel;

public class UserInformationActivity extends BaseActivity<MyViewModel, ActivityUserInformationBinding> implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_user_information;
    }

    @Override
    protected void processLogic() {
        SharedPreferences sp = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        if(sp.getString("username",null) == null ){

        }else{

        }
    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (view.getId()){
                    case R.id.my_username:
                    case R.id.my_sex:
                    case R.id.my_introduction:
                        intent = new Intent(UserInformationActivity.this, MyUpdateActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_tel:
                        intent = new Intent(UserInformationActivity.this, MyTelActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_email:
                        intent = new Intent(UserInformationActivity.this, MyEmailActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
