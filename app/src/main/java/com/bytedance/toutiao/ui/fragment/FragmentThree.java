package com.bytedance.toutiao.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;

/**
 * Data : 2020/10/28
 * Time : 15:56
 * Author : 刘朝阳
 */
public class FragmentThree extends BaseFragment {

    int index;

    public static FragmentThree newFragment(int index){
        FragmentThree fragmentThree = new FragmentThree();
        fragmentThree.index = index;
        return fragmentThree;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_three;
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
