package com.bytedance.toutiao.ui.video.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.databinding.ItemPostDetailBinding;
import com.bytedance.toutiao.databinding.ItemVideoDetailBinding;

import java.util.List;

public class PostDetailAdapter extends RecyclerView.Adapter<PostDetailAdapter.ViewHolder>  {

    private Context context;
    private List<MessageCommentModel> messageCommentModels;

    public PostDetailAdapter(Context context, List<MessageCommentModel> messageCommentModels) {
        this.context = context;
        this.messageCommentModels = messageCommentModels;
    }

    public PostDetailAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_post_detail, parent, false);
        PostDetailAdapter.ViewHolder myHolder = new PostDetailAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemPostDetailBinding binding = (ItemPostDetailBinding) holder.getBinding();
        final MessageCommentModel messageCommentModel = messageCommentModels.get(position);
        binding.tvContent.setText(messageCommentModel.getMsgCommentContent());
        binding.tvName.setText(messageCommentModel.getMsgCommentUserName());
        binding.tvLikeNum.setText(messageCommentModel.getLoveNum());
        binding.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(messageCommentModel.isLove()){
                    messageCommentModel.setLove(false);
                    binding.ivLike.setSelected(false);
                    Integer num = Integer.valueOf(messageCommentModel.getLoveNum());
                    messageCommentModel.setLoveNum((String.valueOf(num - 1)));
                    binding.tvLikeNum.setText(messageCommentModel.getLoveNum());
                }else{
                    messageCommentModel.setLove(true);
                    binding.ivLike.setSelected(true);
                    Integer num = Integer.valueOf(messageCommentModel.getLoveNum());
                    messageCommentModel.setLoveNum((String.valueOf(num + 1)));
                    binding.tvLikeNum.setText(messageCommentModel.getLoveNum());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageCommentModels.size();
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
