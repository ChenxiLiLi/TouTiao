package com.bytedance.toutiao.ui.news.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityNewsDetailBinding;
import com.bytedance.toutiao.ui.news.fragment.FragmentNewsDetail;
import com.bytedance.toutiao.ui.video.adapter.VideoFragmentAdapter;
import com.bytedance.toutiao.ui.video.fragment.FragmentVideoEvent;
import com.bytedance.toutiao.ui.video.fragment.FragmentVideoNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Mr.Chen
 */
public class NewsDetailActivity extends BaseActivity<NormalViewModel, ActivityNewsDetailBinding> {

    private List<Fragment> fragments = new ArrayList<>();
    private FragmentVideoEvent fragmentVideoEvent;
    private FragmentNewNow fragmentNewNow;
    private FragmentVideoNode fragmentNewNode;
    private ViewPager viewPager;
    private VideoFragmentAdapter videoFragmentAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void processLogic() {
        fragmentVideoEvent = new FragmentVideoEvent("1");
        fragmentNewNow = new FragmentNewNow("https://www.toutiao.com/a6886776124567880196/");
        fragmentNewNode = new FragmentVideoNode("1");

        fragments.add(fragmentVideoEvent);
        fragments.add(fragmentNewNow);
        fragments.add(fragmentNewNode);


        viewPager = findViewById(R.id.news_detail_view_pager);
        videoFragmentAdapter = new VideoFragmentAdapter(getSupportFragmentManager(), 0, fragments);

        viewPager.setAdapter(videoFragmentAdapter);
        viewPager.setCurrentItem(1);

    }

    @Override
    protected void setListener() {

    }
}
