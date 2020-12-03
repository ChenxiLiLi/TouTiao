package com.bytedance.toutiao.ui.user.adapter;

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
import com.bytedance.toutiao.bean.TopicModel;
import com.bytedance.toutiao.ui.news.activity.NewsDetailActivity;
import com.bytedance.toutiao.ui.video.activity.TopicSquareActivity;
import com.bytedance.toutiao.utils.NumberUtil;

import java.util.List;


public class MyTopicAdapter extends RecyclerView.Adapter<MyTopicAdapter.ViewHolder> {

    private Context context;
    private List<TopicModel> topicModels;

    public MyTopicAdapter(Context context, List<TopicModel> topicModels){
        this.context = context;
        this.topicModels = topicModels;
    }

    @NonNull
    @Override
    public MyTopicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_my_topic, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTopicAdapter.ViewHolder holder, final int position) {
        if(topicModels != null && !topicModels.isEmpty()){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, TopicSquareActivity.class);
                    intent.putExtra("topicId", topicModels.get(position).getTopicId());
                    context.startActivity(intent);
                }
            });
            holder.topicTitle.setText(topicModels.get(position).getTopicName());
            Log.e("TopicName", topicModels.get(position).getTopicName() + "");
            Log.e("TopicName", holder.topicTitle.getText() + "");
        }
    }

    @Override
    public int getItemCount() {
        return topicModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView topicTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topicTitle = itemView.findViewById(R.id.topic_title);
        }
    }
}
