package com.bytedance.toutiao.ui.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityMyUpdateBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.viewmodel.MyViewModel;

public class MyUpdateActivity extends BaseActivity<MyViewModel, ActivityMyUpdateBinding> {

    private RadioGroup radioGroup;
    private RadioButton male, female;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_update;
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
                String nickname, sex, introduction;
                int sexbt;
                if(view.getId() == R.id.update_back){
                    Intent intent = new Intent(MyUpdateActivity.this, MainActivity.class);
                    startActivity(intent);
                }if(view.getId() == R.id.my_update_save){
                    sexbt = radioGroup.getCheckedRadioButtonId();
                    switch (sexbt){
                        case R.id.sex_male:
                            sex = "男";
                            break;
                        case R.id.sex_female:
                            sex = "女";
                            break;
                    }nickname = mViewModel.nickName.get();
                    introduction = mViewModel.introduction.get();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_update);
        radioGroup = binding.rgSex;
        male = binding.sexMale;
        female = binding.sexFemale;
    }
}
