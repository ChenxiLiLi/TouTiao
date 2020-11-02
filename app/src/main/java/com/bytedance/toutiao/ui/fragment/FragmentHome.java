package com.bytedance.toutiao.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;

/**
 * Data : 2020/10/28
 * Time : 10:56
 * Author : 刘朝阳
 */
public class FragmentHome extends BaseFragment {

    int index;

    public static FragmentHome newFragment(int index){
        FragmentHome fragmentHome = new FragmentHome();
        fragmentHome.index = index;
        return fragmentHome;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
