package com.bytedance.toutiao.ui.user.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.FragmentUserBinding;
import com.bytedance.toutiao.ui.user.activity.AccountManagementActivity;
import com.bytedance.toutiao.ui.user.activity.MyCollectionActivity;
import com.bytedance.toutiao.ui.user.activity.MyCommentActivity;
import com.bytedance.toutiao.ui.user.activity.MyHistoryActivity;
import com.bytedance.toutiao.ui.user.activity.MyPublishActivity;
import com.bytedance.toutiao.ui.user.activity.UserInformationActivity;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.LoginViewModel;
import com.bytedance.toutiao.viewmodel.MyViewModel;

/**
 * Data : 2020/10/28
 * Time : 15:56
 * Author : 刘朝阳
 */
public class FragmentUser extends BaseFragment<MyViewModel, FragmentUserBinding> {

    int index;

    public static FragmentUser newFragment(int index){
        FragmentUser fragmentUser = new FragmentUser();
        fragmentUser.index = index;
        return fragmentUser;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        binding.setViewModel(mViewModel);
        mViewModel.getUser();
    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (view.getId()){
                    case R.id.my_account:
                        ToastUtils.showToast("clicked");
                        intent = new Intent(getActivity(), AccountManagementActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.user_thisuser:
                        intent = new Intent(getActivity(), UserInformationActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_publish:
                        intent = new Intent(getActivity(), MyPublishActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_collection:
                        intent = new Intent(getActivity(), MyCollectionActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_history:
                        intent = new Intent(getActivity(), MyHistoryActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_comment:
                        intent = new Intent(getActivity(), MyCommentActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_focus:
                        intent = new Intent(getActivity(), BaseActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.my_fans:
                        intent = new Intent(getActivity(), BaseActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

}
