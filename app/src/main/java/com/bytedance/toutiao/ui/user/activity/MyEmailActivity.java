package com.bytedance.toutiao.ui.user.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityMyEmailBinding;
import com.bytedance.toutiao.ui.MainActivity;

public class MyEmailActivity extends BaseActivity<NormalViewModel, ActivityMyEmailBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_email;
    }

    @Override
    protected void processLogic() {
        SharedPreferences sp = getSharedPreferences("email", Context.MODE_PRIVATE);
        String email = sp.getString("email",null);
        if(email != null){
            binding.myEmail.setText(email);
        }
    }

    @Override
    protected void setListener() {
//        binding.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent;
//                switch (view.getId()){
//                    case R.id.my_back:
//                        intent = new Intent(MyEmailActivity.this, MainActivity.class);
//                        startActivity(intent);
//                        break;
//                }
//            }
//        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_email);
    }
}
