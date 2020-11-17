package com.bytedance.toutiao.ui.video.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.ui.user.fragment.FragmentUserInfo;
import com.bytedance.toutiao.ui.user.fragment.FragmentUserVideo;
import com.bytedance.toutiao.ui.video.adapter.VideoListFragmentAdapter;
import com.bytedance.toutiao.ui.view.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FragmentVideoNode extends BaseFragment {

    private List<Fragment> fragments = new ArrayList<>();
    private NoScrollViewPager viewPager;
    private String[] strings  = new String[]{"资讯", "视频"};


    public FragmentVideoNode(String videoID) {

    }




    @Override
    protected int getContentViewId() {
        return R.layout.fragment_video_node;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initView();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }

    private void initView() {
        TabLayout mTabLayout = mContentView.findViewById(R.id.tab_layout);
        // 添加 tab item
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB2"));
        //创建三个fragment
        FragmentUserInfo fragmentUserInfo = new FragmentUserInfo();
        FragmentUserVideo fragmentUserVideo = new FragmentUserVideo();

        fragments.add(fragmentUserInfo);
        fragments.add(fragmentUserVideo);

        //获取viewpager
        viewPager = mContentView.findViewById(R.id.view_pager);
        //创建适配器
        VideoListFragmentAdapter myAdapter = new VideoListFragmentAdapter(getFragmentManager(),0,fragments,strings );
        viewPager.setAdapter(myAdapter);
        mTabLayout.setupWithViewPager(viewPager);
    }
}
