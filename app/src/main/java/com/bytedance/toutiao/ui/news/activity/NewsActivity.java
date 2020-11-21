/*
package com.bytedance.toutiao.ui.news.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.ui.news.adapter.NewsFragmentAdapter;
import com.bytedance.toutiao.ui.news.fragment.FragmentNewsFollow;
import com.bytedance.toutiao.ui.news.fragment.FragmentNewsNew;
import com.bytedance.toutiao.ui.news.fragment.FragmentNewsSameCity;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * author: Mr.Chen
 *//*

public class NewsActivity extends BaseActivity {

    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager viewPager;
    private NewsFragmentAdapter newsFragmentAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_news;
    }

    @Override
    protected void processLogic() {

        FragmentNewsFollow followFragment = new FragmentNewsFollow();
        FragmentNewsNew newsFragment = new FragmentNewsNew();
        FragmentNewsSameCity sameCityFragment = new FragmentNewsSameCity();


        fragmentList.add(followFragment);
        fragmentList.add(newsFragment);
        fragmentList.add(sameCityFragment);

        viewPager = findViewById(R.id.home_news_view_pager);
        newsFragmentAdapter = new NewsFragmentAdapter(getSupportFragmentManager(), 0, fragmentList);

        viewPager.setAdapter(newsFragmentAdapter);
        viewPager.setCurrentItem(1);

    }

    @Override
    protected void setListener() {

    }


}
*/
