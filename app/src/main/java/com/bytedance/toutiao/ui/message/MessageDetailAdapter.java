package com.bytedance.toutiao.ui.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;

public class MessageDetailAdapter extends RecyclerView.Adapter<MessageDetailAdapter.ViewHolder>  {

    private Context context;

    public MessageDetailAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MessageDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message_detail, parent, false);
        return new MessageDetailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageDetailAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
