package com.bytedance.toutiao.ui.video.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.ParcablePostData;
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityPostDetailBinding;
import com.bytedance.toutiao.ui.video.adapter.PostDetailAdapter;
import com.bytedance.toutiao.viewmodel.VideoViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostDetailActivity extends BaseActivity<VideoViewModel, ActivityPostDetailBinding> {

    private RecyclerView recyclerView;
    private PostDetailAdapter postDetailAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_post_detail;
    }

    @Override
    protected void processLogic() {
        //接收参数
        Bundle bundle = getIntent().getExtras();
        ParcablePostData parcablePostData = bundle.getParcelable("postDetail");
        binding.tvAuthor.setText("作者：@" + parcablePostData.getAuthorName());
        binding.tvContent.setText(parcablePostData.getContent());
        mViewModel = ViewModelProviders.of(this).get(VideoViewModel.class);
        recyclerView = findViewById(R.id.rv_post_detail);
        postDetailAdapter = new PostDetailAdapter(this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(postDetailAdapter);

    }

    @Override
    protected void setListener() {

    }
}
