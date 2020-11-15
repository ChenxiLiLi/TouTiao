package com.bytedance.toutiao.ui.video.activity;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityVideoDetailBinding;
import com.bytedance.toutiao.ui.video.adapter.VideoFragmentAdapter;
import com.bytedance.toutiao.ui.video.fragment.FragmentVideoDetail;
import com.bytedance.toutiao.ui.video.fragment.FragmentVideoEvent;
import com.bytedance.toutiao.ui.video.fragment.FragmentVideoNode;

import java.util.ArrayList;
import java.util.List;

public class VideoDetailActivity extends BaseActivity<NormalViewModel, ActivityVideoDetailBinding> {

    private List<Fragment> fragments = new ArrayList<>();
    private FragmentVideoEvent fragmentVideoEvent;
    private FragmentVideoDetail fragmentVideoDetail;
    private FragmentVideoNode fragmentVideoNode;
    private ViewPager viewPager;
    private VideoFragmentAdapter videoFragmentAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_video_detail;
    }

    @Override
    protected void processLogic() {
        Intent intent = getIntent();
        String videoID = intent.getStringExtra("videoID");

        fragmentVideoEvent = FragmentVideoEvent.newFragment();
        fragmentVideoDetail = new FragmentVideoDetail(videoID);
        fragmentVideoNode = new FragmentVideoNode(videoID);

        fragments.add(fragmentVideoEvent);
        fragments.add(fragmentVideoDetail);
        fragments.add(fragmentVideoNode);

        viewPager = findViewById(R.id.video_detail_view_pager);
        videoFragmentAdapter = new VideoFragmentAdapter(getSupportFragmentManager(), 0, fragments);

        viewPager.setAdapter(videoFragmentAdapter);
        viewPager.setCurrentItem(1);
    }

    @Override
    protected void setListener() {

    }


}
