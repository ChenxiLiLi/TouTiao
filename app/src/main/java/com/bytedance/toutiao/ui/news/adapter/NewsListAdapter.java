package com.bytedance.toutiao.ui.news.adapter;

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
import com.bytedance.toutiao.ui.video.activity.VideoDetailActivity;
import com.bytedance.toutiao.utils.NumberUtil;

import java.util.List;

/**
 * author: Mr.Chen
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private Context context;
    private List<NewsModel> newsModels;

    public NewsListAdapter(Context context, List<NewsModel> newsModels) {
        this.context = context;
        this.newsModels = newsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListAdapter.ViewHolder holder, final int position) {

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
            //holder.tag.setText(newsModels.get(position).getTag());
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
        //private TextView tag;
        private TextView publishTime;
        private TextView readNum;
        private TextView likeNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.news_title);
            //tag = itemView.findViewById(R.id.news_tag);
            publishTime = itemView.findViewById(R.id.publish_time);
            likeNum = itemView.findViewById(R.id.news_like);
            readNum = itemView.findViewById(R.id.news_read);

        }
    }
}