package com.bytedance.toutiao.ui.video.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.databinding.FragmentVideoEventBinding;
import com.bytedance.toutiao.ui.event.activity.EventSimilarActivity;
import com.bytedance.toutiao.ui.video.adapter.VideoListFragmentAdapter;
import com.bytedance.toutiao.ui.view.NoScrollViewPager;
import com.bytedance.toutiao.viewmodel.VideoViewModel;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.List;

public class FragmentVideoEvent extends BaseFragment<VideoViewModel, FragmentVideoEventBinding> {
    private String eventId;
    private String title = "";
    private List<Fragment> fragments = new ArrayList<>();
    private NoScrollViewPager viewPager;
    private String[] strings  = new String[]{"资讯", "视频"};

    public FragmentVideoEvent() {
    }

    public static FragmentVideoEvent newFragment(String eventId) {
        FragmentVideoEvent fragmentVideoEvent = new FragmentVideoEvent();
        fragmentVideoEvent.eventId = eventId;
        return fragmentVideoEvent;
    }
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_video_event;
    }

    public void setData(String eventId, String title){
        this.eventId = eventId;
        this.title = title;
        binding.tvTitle.setText(title);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        TabLayout mTabLayout = mContentView.findViewById(R.id.tab_layout);
        // 添加 tab item
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TAB2"));

        FragmentEventInfo fragmentEventInfo = new FragmentEventInfo();
        FragmentEventVideo fragmentEventVideo = new FragmentEventVideo();

        fragments.add(fragmentEventInfo);
        fragments.add(fragmentEventVideo);

        //获取viewpager
        viewPager = mContentView.findViewById(R.id.view_pager);
        //创建适配器
        VideoListFragmentAdapter myAdapter = new VideoListFragmentAdapter(getFragmentManager(),0,fragments,strings );
        viewPager.setAdapter(myAdapter);
        mTabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void setListener() {
        TextView textView = mContentView.findViewById(R.id.event_buttom);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.event_buttom:
                        Intent intent1 = new Intent(getContext(), EventSimilarActivity.class);
                        startActivity(intent1);
                        break;
                }
            }
        });
    }




    @Override
    public void onClick(View view) {

    }
}
