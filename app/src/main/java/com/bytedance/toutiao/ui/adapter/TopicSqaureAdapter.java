package com.bytedance.toutiao.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.TopicCommentModel;
import com.bytedance.toutiao.ui.activity.PostDetailActivity;

import java.util.List;

public class TopicSqaureAdapter extends RecyclerView.Adapter<TopicSqaureAdapter.ViewHolder>{

    private List<TopicCommentModel> topicCommentModels;
    private Context context;

    public TopicSqaureAdapter(List<TopicCommentModel> topicCommentModels, Context context) {
        this.topicCommentModels = topicCommentModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_topic_square, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Listener listener = new Listener();
        holder.tvComment.setOnClickListener(listener);
        holder.ivComment.setOnClickListener(listener);
    }

    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, PostDetailActivity.class);
            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUserName;
        private TextView tvComment;
        private ImageView ivLove;
        private ImageView ivComment;
        private ImageView ivCollect;
        private ImageView ivShare;
        private TextView tvLoveNum;
        private TextView tvCommentNum;
        private TextView tvCollectNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tv_user_name);
            tvComment = itemView.findViewById(R.id.tv_content);
            ivLove = itemView.findViewById(R.id.iv_love);
            ivComment = itemView.findViewById(R.id.iv_comment);
            ivCollect = itemView.findViewById(R.id.iv_collect);
            ivShare = itemView.findViewById(R.id.iv_share);
            tvLoveNum = itemView.findViewById(R.id.tv_love_num);
            tvCommentNum = itemView.findViewById(R.id.tv_comment_num);
            tvCollectNum = itemView.findViewById(R.id.tv_collect_num);
        }
    }
}
