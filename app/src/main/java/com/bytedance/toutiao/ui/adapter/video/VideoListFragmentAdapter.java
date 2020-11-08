package com.bytedance.toutiao.ui.adapter.video;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class VideoListFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;
    String[] strings = new String[]{"关注", "视频", "同城"};


    public VideoListFragmentAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList) {
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
