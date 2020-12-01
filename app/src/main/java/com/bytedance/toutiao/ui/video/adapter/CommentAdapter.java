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
import com.bytedance.toutiao.databinding.ItemCommentBinding;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    private Context context;
    private List<MessageCommentModel> messageCommentModels;

    public CommentAdapter(Context context, List<MessageCommentModel> messageCommentModels) {
        this.context = context;
        this.messageCommentModels = messageCommentModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_comment, parent, false);
        CommentAdapter.ViewHolder myHolder = new CommentAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemCommentBinding binding = (ItemCommentBinding) holder.getBinding();
        final MessageCommentModel messageCommentModel = messageCommentModels.get(position);
        binding.tvContent.setText(messageCommentModel.getMsgCommentContent());
        binding.tvLikecount.setText(messageCommentModel.getLoveNum());
        binding.tvNickname.setText(messageCommentModel.getMsgCommentName());
        binding.ivIsLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(messageCommentModel.isLove()){
                    messageCommentModel.setLove(false);
                    binding.ivIsLove.setSelected(false);
                    Integer num = Integer.valueOf(messageCommentModel.getLoveNum());
                    messageCommentModel.setLoveNum((String.valueOf(num - 1)));
                    binding.tvLikecount.setText(messageCommentModel.getLoveNum());
                }else{
                    messageCommentModel.setLove(true);
                    binding.ivIsLove.setSelected(true);
                    Integer num = Integer.valueOf(messageCommentModel.getLoveNum());
                    messageCommentModel.setLoveNum((String.valueOf(num + 1)));
                    binding.tvLikecount.setText(messageCommentModel.getLoveNum());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageCommentModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ViewDataBinding binding;

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
