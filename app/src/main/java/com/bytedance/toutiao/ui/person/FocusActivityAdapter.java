package com.bytedance.toutiao.ui.person;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.ui.video.activity.TopicSquareActivity;

import java.util.List;

public class FocusActivityAdapter extends RecyclerView.Adapter<FocusActivityAdapter.ViewHolder>{
    private Context context;
    private List<User> focus;

    public FocusActivityAdapter(Context context, List<User> focus) {
        this.context = context;
        this.focus = focus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_focus, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if(focus != null && !focus.isEmpty()){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, TopicSquareActivity.class);
                    intent.putExtra("topicId", focus.get(position).getId());
                    context.startActivity(intent);
                }
            });
            holder.tvName.setText(focus.get(position).getNickname());
            Log.e("TopicName", focus.get(position).getNickname() + "");
            Log.e("TopicName", holder.tvName.getText() + "");
        }
    }


    @Override
    public int getItemCount() {
        return focus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
