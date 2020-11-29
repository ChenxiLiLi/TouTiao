package com.bytedance.toutiao.ui.user.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityMyTelBinding;

public class MyTelActivity extends BaseActivity<NormalViewModel, ActivityMyTelBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_tel;
    }

    @Override
    protected void processLogic() {
        SharedPreferences sp = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        CharSequence tel = sp.getString("phoneNum",null);
        if(tel != null){
            binding.myTel.setText(tel);
        }
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tel);
    }
}
