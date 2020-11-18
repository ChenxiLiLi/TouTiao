package com.bytedance.toutiao.ui.video.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class VideoListFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    String[] strings;


    public VideoListFragmentAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList,String[] strings) {
        super(fm, behavior);
        this.fragmentList = fragmentList;
        this.strings = strings;
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
