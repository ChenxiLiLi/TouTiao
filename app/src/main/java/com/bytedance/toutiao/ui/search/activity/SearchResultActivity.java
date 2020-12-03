package com.bytedance.toutiao.ui.search.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivitySearchResultBinding;
import com.bytedance.toutiao.ui.video.adapter.VideoListFragmentAdapter;
import com.bytedance.toutiao.ui.video.fragment.FragmentEventInfo;
import com.bytedance.toutiao.ui.video.fragment.FragmentEventVideo;
import com.bytedance.toutiao.ui.view.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends BaseActivity<NormalViewModel, ActivitySearchResultBinding> {
    private String eventId;
    private String title = "";
    private List<Fragment> fragments = new ArrayList<>();
    private NoScrollViewPager viewPager;
    private String[] strings  = new String[]{"资讯", "视频"};

    @Override
    protected int getContentViewId() {
        return R.layout.activity_search_result;
    }

    @Override
    protected void processLogic() {
        TabLayout mTabLayout = findViewById(R.id.tab_layout);
        // 添加 tab item
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB2"));

        FragmentEventInfo fragmentEventInfo = new FragmentEventInfo();
        FragmentEventVideo fragmentEventVideo = new FragmentEventVideo();

        fragments.add(fragmentEventInfo);
        fragments.add(fragmentEventVideo);

        //获取viewpager
        viewPager = findViewById(R.id.view_pager);
        //创建适配器
        VideoListFragmentAdapter myAdapter = new VideoListFragmentAdapter(getSupportFragmentManager(),0,fragments,strings );
        viewPager.setAdapter(myAdapter);
        mTabLayout.setupWithViewPager(viewPager);
        binding.tvTitle.setText("\""+getIntent().getStringExtra("seatchContext")+"\""+"的搜索结果");
    }

    @Override
    protected void setListener() {

    }

}
