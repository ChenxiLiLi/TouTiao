package com.bytedance.toutiao.ui.news.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.databinding.ActivityNewsDetailBinding;
import com.bytedance.toutiao.ui.news.adapter.NewsFragmentAdapter;
import com.bytedance.toutiao.ui.news.fragment.FragmentNewsDetail;
import com.bytedance.toutiao.ui.video.fragment.FragmentVideoEvent;
import com.bytedance.toutiao.ui.video.fragment.FragmentVideoNode;
import com.bytedance.toutiao.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Mr.Chen
 */
public class NewsDetailActivity extends BaseActivity<NewsViewModel, ActivityNewsDetailBinding> {

    private ViewPager viewPager;
    private FragmentNewsDetail fragmentNewsDetail;
    private NewsFragmentAdapter newsFragmentAdapter;
    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void processLogic() {

        fragmentNewsDetail = new FragmentNewsDetail();
        fragmentList.add(fragmentNewsDetail);
        newsFragmentAdapter = new NewsFragmentAdapter(getSupportFragmentManager(), 0, fragmentList);
        viewPager = findViewById(R.id.news_detail_view_pager);
        viewPager.setAdapter(newsFragmentAdapter);
        viewPager.setCurrentItem(1);
    }

    @Override
    protected void setListener() {

    }
}
