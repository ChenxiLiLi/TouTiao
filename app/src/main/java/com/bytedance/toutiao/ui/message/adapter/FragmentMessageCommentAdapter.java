package com.bytedance.toutiao.ui.message.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;

public class FragmentMessageCommentAdapter extends RecyclerView.Adapter<FragmentMessageCommentAdapter.ViewHolder> {
    private Context context;

    public FragmentMessageCommentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FragmentMessageCommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message_comment, parent, false);
        return new FragmentMessageCommentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMessageCommentAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
