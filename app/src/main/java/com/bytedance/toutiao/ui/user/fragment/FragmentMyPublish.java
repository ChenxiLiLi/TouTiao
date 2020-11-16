package com.bytedance.toutiao.ui.user.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.FragmentMyPublishBinding;
import com.bytedance.toutiao.ui.user.adapter.HistoryAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class FragmentMyPublish extends BaseFragment<NormalViewModel, FragmentMyPublishBinding> {
    int index;

    private ViewPager viewPager;
    private FragmentUserInfo fragment_info;
    private FragmentUserVideo fragment_video;
    private HistoryAdapter historyAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();

    public static FragmentMyPublish newFragment(int index){
        FragmentMyPublish fragmentMyPublish = new FragmentMyPublish();
        fragmentMyPublish.index = index;
        return fragmentMyPublish;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_my_publish;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        TabLayout mTabLayout = binding.tabLayout;
        // 添加 tab item
        mTabLayout.addTab(mTabLayout.newTab().setText("资讯"));
        mTabLayout.addTab(mTabLayout.newTab().setText("视频"));
        fragment_info = new FragmentUserInfo();
        fragment_video = new FragmentUserVideo();
        fragmentList.add(fragment_info);
        fragmentList.add(fragment_video);
        historyAdapter = new HistoryAdapter(getFragmentManager(),0, fragmentList);
        viewPager = binding.viewPager;
        viewPager.setAdapter(historyAdapter);
        mTabLayout.setupWithViewPager(viewPager);
        viewPager.setId(fragmentList.get(0).hashCode());
    }

    @Override
    protected void setListener() {
    }

    @Override
    public void onClick(View view) {

    }
}
