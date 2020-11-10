package com.bytedance.toutiao.ui.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityPostDetailBinding;
import com.bytedance.toutiao.ui.adapter.PostDetailAdapter;

public class PostDetailActivity extends BaseActivity<NormalViewModel, ActivityPostDetailBinding> {

    private RecyclerView recyclerView;
    private PostDetailAdapter postDetailAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_post_detail;
    }

    @Override
    protected void processLogic() {
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
