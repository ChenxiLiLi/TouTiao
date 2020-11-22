package com.bytedance.toutiao.ui.video.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.ImageModel;
import com.bytedance.toutiao.databinding.ItemPostPicBinding;

import java.util.List;

public class PostPublishAdapter extends RecyclerView.Adapter<PostPublishAdapter.ViewHolder> {

    private Context mcontext;
    private List<ImageModel> list;
    private Listener listener;

    public PostPublishAdapter(Context mcontext, List<ImageModel> list) {
        this.mcontext = mcontext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_post_pic, parent, false);
        PostPublishAdapter.ViewHolder myHolder = new PostPublishAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemPostPicBinding binding = (ItemPostPicBinding) holder.getBinding();
        final RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        ImageModel imageModel = list.get(position);
        if(imageModel.getRsId() == 0)
            Glide.with(mcontext).load(imageModel.getFilePath()).apply(options).into(binding.ivPic);
        else
            Glide.with(mcontext).load(imageModel.getRsId()).apply(options).into(binding.ivPic);
        binding.ivPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface Listener {
        void onClick();
    }

    public void setListener(Listener listener){
        this.listener = listener;
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
