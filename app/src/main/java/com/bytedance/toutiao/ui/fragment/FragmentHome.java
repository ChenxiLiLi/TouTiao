package com.bytedance.toutiao.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.ui.adapter.home.HomeListFragmentAdapter;
import com.bytedance.toutiao.ui.fragment.home.HomeBaseFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Data : 2020/10/28
 * Time : 10:56
 * Author : 刘朝阳
 */
public class FragmentHome extends BaseFragment {

    int index;

    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager viewPager;

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
        TabLayout mTabLayout = mContentView.findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("tab1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tab2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tab3"));

        HomeBaseFragment followFragment = new HomeBaseFragment("follow");
        HomeBaseFragment newsFragment = new HomeBaseFragment("news");
        HomeBaseFragment sameCityFragment = new HomeBaseFragment("sameCity");


        fragmentList.add(followFragment);
        fragmentList.add(newsFragment);
        fragmentList.add(sameCityFragment);


        HomeListFragmentAdapter homeAdapter = new HomeListFragmentAdapter(getFragmentManager(),0, fragmentList);

        viewPager = mContentView.findViewById(R.id.home_view_pager);
        viewPager.setAdapter(homeAdapter);
        mTabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
