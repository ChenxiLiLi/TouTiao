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
public class FragmentTwo extends BaseFragment {

    int index;

    public static FragmentTwo newFragment(int index){
        FragmentTwo fragmentTwo = new FragmentTwo();
        fragmentTwo.index = index;
        return fragmentTwo;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_two;
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
