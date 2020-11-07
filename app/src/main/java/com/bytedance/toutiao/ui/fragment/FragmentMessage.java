package com.bytedance.toutiao.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;

import androidx.annotation.Nullable;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;

/**
 * Data : 2020/10/28
 * Time : 15:56
 * Author : 刘朝阳
 */
public class FragmentMessage extends BaseFragment implements TabHost.OnTabChangeListener {

    int index;

    public static FragmentMessage newFragment(int index){
        FragmentMessage fragmentMessage = new FragmentMessage();
        fragmentMessage.index = index;
        return fragmentMessage;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RelativeLayout layout = null;
        layout = (RelativeLayout) inflater.inflate(R.layout.fragment_message,null);
        TabHost tabHost =(TabHost) layout.findViewById(R.id.tabhost_message);
        tabHost.getTabContentView();
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("tag_message_private").setIndicator("私信").setContent(R.id.tab_private));
        tabHost.addTab(tabHost.newTabSpec(null).setIndicator("评论"));
        tabHost.addTab(tabHost.newTabSpec(null).setIndicator("赞和粉"));

        tabHost.setCurrentTab(0);
        tabHost.setOnTabChangedListener(this);
        return layout;

    }

    @Override
    public void onTabChanged(String s) {

    }
}
