package com.bytedance.toutiao.ui.news.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.ui.news.adapter.NewsListFragmentAdapter;
import com.bytedance.toutiao.ui.search.activity.SearchActivity;
import com.bytedance.toutiao.ui.video.adapter.VideoListFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * author: Mr.Chen
 */
public class FragmentNews extends BaseFragment {

    int index;

    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager viewPager;

    public static FragmentNews newFragment(int index){
        FragmentNews fragmentNews = new FragmentNews();
        fragmentNews.index = index;
        return fragmentNews;
    }

    public FragmentNews() {}

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        TabLayout tabLayout = mContentView.findViewById(R.id.news_tab_layout);

        tabLayout.addTab(tabLayout.newTab().setText("TAB1"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB2"));
        tabLayout.addTab(tabLayout.newTab().setText("TAB3"));

        FragmentNewsFollow followFragment = new FragmentNewsFollow();
        FragmentNewsNew newsFragment = new FragmentNewsNew();
        FragmentNewsSameCity sameCityFragment = new FragmentNewsSameCity();


        fragmentList.add(followFragment);
        fragmentList.add(newsFragment);
        fragmentList.add(sameCityFragment);

        //获取viewpager
        viewPager = mContentView.findViewById(R.id.news_view_pager);
        //创建适配器
        NewsListFragmentAdapter newsListFragmentAdapter = new NewsListFragmentAdapter(getFragmentManager(),0,fragmentList);
        viewPager.setAdapter(newsListFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
        viewPager.setId(fragmentList.get(1).hashCode());
    }

    @Override
    protected void setListener() {
        ImageView imageView = mContentView.findViewById(R.id.news_search);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "进入搜索界面", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
