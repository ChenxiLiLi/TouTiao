package com.bytedance.toutiao.ui.person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityAuthorBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.ui.message.Activity.MessageChatActivity;
import com.bytedance.toutiao.ui.video.adapter.VideoListFragmentAdapter;
import com.bytedance.toutiao.ui.video.fragment.FragmentEventInfo;
import com.bytedance.toutiao.ui.video.fragment.FragmentEventVideo;
import com.bytedance.toutiao.ui.view.NoScrollViewPager;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class AuthorActivity extends BaseActivity<MessageCommentViewModel, ActivityAuthorBinding> {
    private Context context;
    private List<Fragment> fragments = new ArrayList<>();
    private NoScrollViewPager viewPager;
    private String[] strings  = new String[]{"资讯", "视频"};
    private Listener listener;
    FansActivity fansActivity;

    public interface Listener extends View.OnClickListener{
        @Override
        void onClick(View view);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }


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

        mViewModel = ViewModelProviders.of(this).get(MessageCommentViewModel.class);
        binding.title.setText(getIntent().getStringExtra("title"));
    }


    @Override
    protected void setListener() {

        binding.fans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthorActivity.this,FansActivity.class);
                intent.putExtra("title","粉丝");
                startActivity(intent);
            }
        });
        binding.focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthorActivity.this,FansActivity.class);
                intent.putExtra("title","关注");
                startActivity(intent);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.btnFocus.getText().toString().indexOf("关注") != -1 ){
                    binding.btnFocus.setText("已关注");
                }
                else if (binding.btnFocus.getText().toString().indexOf("已关注") != -1 ){
                    binding.btnFocus.setText("关注");
                }
            }
        });
        binding.btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthorActivity.this, MessageChatActivity.class);
                intent.putExtra("title", binding.title.getText().toString());
                startActivity(intent);
            }
        });
        binding.ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,binding.title.getText().toString());
                intent.setType("text/plain");
                AuthorActivity.this.startActivity(intent);
            }
        });
        binding.content.setOnClickListener(new View.OnClickListener() {
            boolean i = true;
            @Override
            public void onClick(View view) {
                if (i){
                    binding.content.setMaxLines(10000);
                    i = false;
                }
                else {
                    binding.content.setMaxLines(1);
                    i = true;
                }

            }
        });
    }

}
