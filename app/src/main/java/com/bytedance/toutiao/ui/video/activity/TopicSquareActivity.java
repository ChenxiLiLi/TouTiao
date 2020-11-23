package com.bytedance.toutiao.ui.video.activity;


import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.TopicCommentModel;
import com.bytedance.toutiao.databinding.ActivityTopicSquareBinding;
import com.bytedance.toutiao.ui.video.adapter.PostPublishAdapter;
import com.bytedance.toutiao.ui.video.adapter.TopicSqaureAdapter;
import com.bytedance.toutiao.viewmodel.VideoViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopicSquareActivity extends BaseActivity<VideoViewModel, ActivityTopicSquareBinding> {

    private TopicSqaureAdapter topicSqaureAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<PostDetailModel> postDetailModels = new ArrayList<>();


    @Override
    protected int getContentViewId() {
        return R.layout.activity_topic_square;
    }

    @Override
    protected void processLogic() {
        mViewModel = ViewModelProviders.of(this).get(VideoViewModel.class);

        topicSqaureAdapter = new TopicSqaureAdapter(postDetailModels, this);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvTopicSquare.setLayoutManager(linearLayoutManager);


        mViewModel.getPostByEventId("1")
                .observe(this, new Observer<Resource<List<PostDetailModel>>>() {
                    @Override
                    public void onChanged(Resource<List<PostDetailModel>> listResource) {
                        if(listResource.state == 1){
                            PostDetailModel postDetailModel = listResource.data.get(0);
                            binding.tvTopicName.setText(postDetailModel.getTopicName());
                            binding.tvMoveNum.setText(postDetailModel.getTopicPostNum());
                            binding.tvReadNum.setText(postDetailModel.getTopicReadNum());
                            postDetailModels.addAll(listResource.data);
                            topicSqaureAdapter.notifyDataSetChanged();
                        }

                    }
                });
        binding.rvTopicSquare.setAdapter(topicSqaureAdapter);

    }

    @Override
    protected void setListener() {
        binding.btnJoinNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPublish = new Intent(TopicSquareActivity.this, PostPublishActivity.class);
                startActivity(toPublish);
            }
        });
    }

    private void init(){

    }

}
