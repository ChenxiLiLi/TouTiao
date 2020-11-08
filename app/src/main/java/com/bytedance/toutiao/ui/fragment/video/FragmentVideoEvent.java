package com.bytedance.toutiao.ui.fragment.video;

import android.os.Bundle;
import android.view.View;


import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;

public class FragmentVideoEvent extends BaseFragment {


    public static FragmentVideoEvent newFragment(){
        FragmentVideoEvent fragmentVideoEvent = new FragmentVideoEvent();
        return fragmentVideoEvent;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_video_event;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
