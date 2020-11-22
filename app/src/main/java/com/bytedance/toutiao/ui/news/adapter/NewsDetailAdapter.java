package com.bytedance.toutiao.ui.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.ui.news.activity.NewsDetailActivity;
import com.bytedance.toutiao.utils.NumberUtil;

import java.util.List;

/**
 * author: Mr.Chen
 */
public class NewsDetailAdapter extends RecyclerView.Adapter<NewsDetailAdapter.ViewHolder> {

    private Context context;
    private List<NewsModel> newsModels;
    private Resources resources;
    private Listener listener;

    public NewsDetailAdapter(Context context, Resources resources, List<NewsModel> newsModels) {
        this.context = context;
        this.resources = resources;
        this.newsModels = newsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_news_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if(newsModels != null && !newsModels.isEmpty()) {

        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private WebView webView;
        private ImageView ivLoading;
        private LinearLayout layoutBottom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            webView = itemView.findViewById(R.id.wv_content);
            ivLoading = itemView.findViewById(R.id.iv_loading);
            layoutBottom = itemView.findViewById(R.id.ll_comment);
        }
    }

    public interface Listener extends View.OnClickListener{
        @Override
        void onClick(View view);

        void refresh(NewsModel newsModel);
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }
}
