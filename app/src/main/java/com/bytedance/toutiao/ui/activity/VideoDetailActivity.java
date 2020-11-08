package com.bytedance.toutiao.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.ui.adapter.video.VideoFragmentAdapter;
import com.bytedance.toutiao.ui.fragment.video.FragmentVideoDetail;
import com.bytedance.toutiao.ui.fragment.video.FragmentVideoEvent;
import com.bytedance.toutiao.ui.fragment.video.FragmentVideoNode;

import java.util.ArrayList;
import java.util.List;

public class VideoDetailActivity extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private FragmentVideoEvent fragmentVideoEvent;
    private FragmentVideoDetail fragmentVideoDetail;
    private FragmentVideoNode fragmentVideoNode;
    private ViewPager viewPager;
    private VideoFragmentAdapter videoFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        fragmentVideoEvent = FragmentVideoEvent.newFragment();
        fragmentVideoDetail = FragmentVideoDetail.newFragment();
        fragmentVideoNode = FragmentVideoNode.newFragment();

        fragments.add(fragmentVideoEvent);
        fragments.add(fragmentVideoDetail);
        fragments.add(fragmentVideoNode);

        viewPager = findViewById(R.id.video_detail_view_pager);
        videoFragmentAdapter = new VideoFragmentAdapter(getSupportFragmentManager(), 0, fragments);

        viewPager.setAdapter(videoFragmentAdapter);
        viewPager.setCurrentItem(1);
    }
}
