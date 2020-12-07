package com.bytedance.toutiao.ui.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.ui.news.activity.NewsDetailActivity;
import com.bytedance.toutiao.utils.NumberUtil;

import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder> {

    private Context context;
    private List<NewsModel> newsModels;

    public UserInfoAdapter(Context context, List<NewsModel> newsModels) {
        this.context = context;
        this.newsModels = newsModels;
    }

    @NonNull
    @Override
    public UserInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserInfoAdapter.ViewHolder holder, final int position) {
        if(newsModels != null && !newsModels.isEmpty()) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, NewsDetailActivity.class);
                    intent.putExtra("newsId", newsModels.get(position).getId());
                    context.startActivity(intent);
                }
            });

            holder.title.setText(newsModels.get(position).getTitle());
            holder.publishTime.setText(newsModels.get(position).getPublishTime());
            holder.likeNum.setText("赞"+ NumberUtil.conver(newsModels.get(position).getLikeNum()));
            holder.readNum.setText("阅读"+ NumberUtil.conver(newsModels.get(position).getReadNum()));
        }
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView publishTime;
        private TextView readNum;
        private TextView likeNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            publishTime = itemView.findViewById(R.id.publish_time);
            likeNum = itemView.findViewById(R.id.news_like);
            readNum = itemView.findViewById(R.id.news_read);
        }
    }
}