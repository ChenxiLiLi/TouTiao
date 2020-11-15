package com.bytedance.toutiao.ui.message.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;

public class FragmentMessageFocusAdapter extends RecyclerView.Adapter<FragmentMessageFocusAdapter.ViewHolder> {
    private Context context;

    public FragmentMessageFocusAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FragmentMessageFocusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message_focus, parent, false);
        return new FragmentMessageFocusAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMessageFocusAdapter.ViewHolder holder, int position) {

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
