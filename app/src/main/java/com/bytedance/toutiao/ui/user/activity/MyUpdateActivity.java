package com.bytedance.toutiao.ui.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityMyUpdateBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.MyViewModel;

public class MyUpdateActivity extends BaseActivity<MyViewModel, ActivityMyUpdateBinding> {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_update;
    }

    @Override
    protected void processLogic() {
        binding.setViewModel(mViewModel);
        mViewModel.getUser();
        if(mViewModel.sex.equals("女")){
            binding.sexFemale.setChecked(true);
        }
    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (view.getId()){
                    case R.id.update_back:
                        intent = new Intent(MyUpdateActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_update_save:
                        switch (binding.rgSex.getCheckedRadioButtonId()){
                            case R.id.sex_male:
                                mViewModel.sex.set("男");
                                break;
                            case R.id.sex_female:
                                mViewModel.sex.set("女");
                                break;
                        }mViewModel.myUpdate().observe(MyUpdateActivity.this, new Observer<Resource<String>>() {
                        @Override
                        public void onChanged(Resource<String> stringResource) {
                            Log.e("update", stringResource.state +"");
                        }
                    });
                        //mViewModel.localUpdate();
                        intent = new Intent(MyUpdateActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
