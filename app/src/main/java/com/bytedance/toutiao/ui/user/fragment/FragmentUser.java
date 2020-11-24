package com.bytedance.toutiao.ui.user.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.FragmentUserBinding;
import com.bytedance.toutiao.ui.user.activity.AccountManagementActivity;

/**
 * Data : 2020/10/28
 * Time : 15:56
 * Author : 刘朝阳
 */
public class FragmentUser extends BaseFragment<NormalViewModel, FragmentUserBinding> {

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

    }

    @Override
    protected void setListener() {
        binding.myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toAccountManagement = new Intent(getActivity(), AccountManagementActivity.class);
                getActivity().startActivity(toAccountManagement);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

}
