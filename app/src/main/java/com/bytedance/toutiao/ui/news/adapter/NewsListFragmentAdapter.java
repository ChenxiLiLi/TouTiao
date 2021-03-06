package com.bytedance.toutiao.ui.news.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author: Mr.Chen
 */
public class NewsListFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    String[] strings = new String[]{"关注", "资讯", "同城"};


    public NewsListFragmentAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList) {
        super(fm, behavior);
        this.fragmentList = fragmentList;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return strings[position];
    }

}
