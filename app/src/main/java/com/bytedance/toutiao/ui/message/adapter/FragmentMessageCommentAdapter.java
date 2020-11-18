package com.bytedance.toutiao.ui.message.adapter;

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
import com.bytedance.toutiao.databinding.ItemMessageCommentBinding;
import com.bytedance.toutiao.databinding.ItemVideoDetailBinding;
import com.bytedance.toutiao.ui.video.adapter.VideoDetailAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentMessageCommentAdapter extends RecyclerView.Adapter<FragmentMessageCommentAdapter.ViewHolder> {
    private Context context;
    private List<MessageCommentModel> messageCommentModels ;
    public FragmentMessageCommentAdapter(Context context, List<MessageCommentModel> messageCommentModels) {
        this.context = context;
        this.messageCommentModels = messageCommentModels;
    }

    @NonNull
    @Override
    public FragmentMessageCommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_message_comment, parent, false);
        FragmentMessageCommentAdapter.ViewHolder myHolder = new FragmentMessageCommentAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMessageCommentAdapter.ViewHolder holder, int position) {
        ItemMessageCommentBinding binding = (ItemMessageCommentBinding) holder.getBinding();
        binding.tvName.setText(messageCommentModels.get(position).getMsgCommentUserName());
        binding.tvContent.setText(messageCommentModels.get(position).getMsgCommentContent());
    }

    @Override
    public int getItemCount() {
        return messageCommentModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public ViewDataBinding getBinding(){
            return binding;
        }

        public void setBinding(ViewDataBinding binding){
            this.binding = binding;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
