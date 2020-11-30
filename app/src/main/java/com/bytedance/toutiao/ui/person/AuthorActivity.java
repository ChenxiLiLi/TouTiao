package com.bytedance.toutiao.ui.person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityAuthorBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.ui.video.adapter.VideoListFragmentAdapter;
import com.bytedance.toutiao.ui.video.fragment.FragmentEventInfo;
import com.bytedance.toutiao.ui.video.fragment.FragmentEventVideo;
import com.bytedance.toutiao.ui.view.NoScrollViewPager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AuthorActivity extends BaseActivity<NormalViewModel, ActivityAuthorBinding> {
    private List<Fragment> fragments = new ArrayList<>();
    private NoScrollViewPager viewPager;
    private String[] strings  = new String[]{"资讯", "视频"};

    @Override
    protected int getContentViewId() {
        return R.layout.activity_author;
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
    }

    @Override
    protected void setListener() {

        binding.fans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AuthorActivity.this, "进入粉丝页", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AuthorActivity.this, FansActivity.class);
                startActivity(intent);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
