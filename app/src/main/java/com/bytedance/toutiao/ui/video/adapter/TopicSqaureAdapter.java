package com.bytedance.toutiao.ui.video.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.ParcablePostData;
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.bean.TopicCommentModel;
import com.bytedance.toutiao.databinding.ItemPostDetailBinding;
import com.bytedance.toutiao.databinding.ItemTopicSquareBinding;
import com.bytedance.toutiao.ui.video.activity.PostDetailActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopicSqaureAdapter extends RecyclerView.Adapter<TopicSqaureAdapter.ViewHolder>{

    private List<PostDetailModel> postDetailModels;
    private Context context;

    public TopicSqaureAdapter(List<PostDetailModel> postDetailModels, Context context) {
        this.postDetailModels = postDetailModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_topic_square, parent, false);
        TopicSqaureAdapter.ViewHolder myHolder = new TopicSqaureAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemTopicSquareBinding binding = (ItemTopicSquareBinding) holder.getBinding();
        final PostDetailModel postDetailModel = postDetailModels.get(position);
        binding.tvUserName.setText(postDetailModel.getAuthorName());
        binding.tvContent.setText(postDetailModel.getContent());
        binding.tvCommentNum.setText(postDetailModel.getCommentNum());
        binding.tvLoveNum.setText(postDetailModel.getLoveNum());
        binding.tvPosition.setText(postDetailModel.getPosition());

        binding.ivComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPostDetail = new Intent();
                toPostDetail.setClass(context,PostDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("postDetail", new ParcablePostData(postDetailModel));
                toPostDetail.putExtras(bundle);
                context.startActivity(toPostDetail);
            }
        });

        binding.ivLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(postDetailModel.isLove()){
                    postDetailModel.setLove(false);
                    binding.ivLove.setSelected(false);
                    Integer num = Integer.valueOf(postDetailModel.getLoveNum());
                    postDetailModel.setLoveNum((String.valueOf(num - 1)));
                    binding.tvLoveNum.setText(postDetailModel.getLoveNum());
                }else{
                    postDetailModel.setLove(true);
                    binding.ivLove.setSelected(true);
                    Integer num = Integer.valueOf(postDetailModel.getLoveNum());
                    postDetailModel.setLoveNum((String.valueOf(num + 1)));
                    binding.tvLoveNum.setText(postDetailModel.getLoveNum());
                }
            }
        });

    }





    @Override
    public int getItemCount() {
        return postDetailModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ViewDataBinding binding;

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
