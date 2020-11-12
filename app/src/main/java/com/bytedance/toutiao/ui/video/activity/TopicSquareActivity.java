package com.bytedance.toutiao.ui.video.activity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.TopicCommentModel;
import com.bytedance.toutiao.databinding.ActivityTopicSquareBinding;
import com.bytedance.toutiao.ui.video.adapter.TopicSqaureAdapter;

import java.util.ArrayList;
import java.util.List;

public class TopicSquareActivity extends BaseActivity<NormalViewModel, ActivityTopicSquareBinding> {

    private RecyclerView recyclerView;
    private TopicSqaureAdapter topicSqaureAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<TopicCommentModel> topicCommentModels = new ArrayList<>();


    @Override
    protected int getContentViewId() {
        return R.layout.activity_topic_square;
    }

    @Override
    protected void processLogic() {
        recyclerView = findViewById(R.id.rv_topic_square);
        topicSqaureAdapter = new TopicSqaureAdapter(topicCommentModels, this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(topicSqaureAdapter);



    }

    @Override
    protected void setListener() {

    }

    private void init(){

    }

}
