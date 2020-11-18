package com.bytedance.toutiao.ui.video.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.ui.video.adapter.VideoListFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Data : 2020/10/28
 * Time : 15:56
 * Author : 刘朝阳
 */
public class FragmentVideo extends BaseFragment {

    int index;

    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager viewPager;
    private String[] strings  = new String[]{"关注", "视频", "同城"};

    public static FragmentVideo newFragment(int index){
        FragmentVideo fragmentVideo = new FragmentVideo();
        fragmentVideo.index = index;
        return fragmentVideo;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        TabLayout mTabLayout = mContentView.findViewById(R.id.tab_layout);
        // 添加 tab item
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB3"));
        //创建三个fragment
        FragmentFocusVideo fragmentFocusVideo = new FragmentFocusVideo();
        FragmentRecommentVideo fragmentRecommentVideo = new FragmentRecommentVideo();
        FragmentCityVideo fragmentCityVideo = new FragmentCityVideo();

        fragments.add(fragmentFocusVideo);
        fragments.add(fragmentRecommentVideo);
        fragments.add(fragmentCityVideo);
        //获取viewpager
        viewPager = mContentView.findViewById(R.id.view_pager);
        //创建适配器
        VideoListFragmentAdapter myAdapter = new VideoListFragmentAdapter(getFragmentManager(),0,fragments,strings );
        viewPager.setAdapter(myAdapter);
        mTabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
        viewPager.setId(fragments.get(1).hashCode());
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
