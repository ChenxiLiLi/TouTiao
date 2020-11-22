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
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.databinding.ItemPostDetailBinding;
import com.bytedance.toutiao.databinding.ItemVideoDetailBinding;

import java.util.List;

public class PostDetailAdapter extends RecyclerView.Adapter<PostDetailAdapter.ViewHolder>  {

    private Context context;
    private List<PostDetailModel> postDetailModels;

    public PostDetailAdapter(Context context, List<PostDetailModel> postDetailModels) {
        this.context = context;
        this.postDetailModels = postDetailModels;
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
        ViewDataBinding binding = (ItemPostDetailBinding) holder.getBinding();

    }

    @Override
    public int getItemCount() {
        return 3;
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
