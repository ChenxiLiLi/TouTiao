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
import com.bytedance.toutiao.viewmodel.MyViewModel;

public class UserInformationActivity extends BaseActivity<MyViewModel, ActivityUserInformationBinding>{

    @Override
    protected int getContentViewId() {
        return R.layout.activity_user_information;
    }

    @Override
    protected void processLogic() {
        binding.setViewModel(mViewModel);
        SharedPreferences sp = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
//        if(sp.getString("username",null) != null ){
//            binding.textUsername.setText(sp.getString("nickname",null));
//            binding.textSex.setText(sp.getString("sex", null));
//            binding.textTel.setText(sp.getString("phoneNum",null));
//            binding.textEmail.setText(sp.getString("email",null));
//            binding.textIntroduction.setText(sp.getString("introduction",null));

//        }
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
