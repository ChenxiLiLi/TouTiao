package com.bytedance.toutiao.ui.news.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.ui.view.MyScrollview;
import com.bytedance.toutiao.utils.ToastUtils;

public class NewsNowAdapter extends RecyclerView.Adapter<NewsNowAdapter.ViewHolder> {

    private Context context;

    public NewsNowAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_now, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mWvContent.loadUrl("https://www.toutiao.com/a6886776124567880196/");


        WebSettings settings = holder.mWvContent.getSettings();
        settings.setJavaScriptEnabled(true);
        holder.mWvContent.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                holder.ivLoading.setVisibility(View.GONE);
                holder.layoutBottom.setVisibility(View.VISIBLE);
            }
        });

        holder.mWvContent.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
            }
        });



    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private WebView mWvContent;
        private ImageView ivLoading;
        private LinearLayout layoutBottom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mWvContent = itemView.findViewById(R.id.wv_content);
            ivLoading = itemView.findViewById(R.id.iv_loading);
            layoutBottom = itemView.findViewById(R.id.ll_comment);
        }
    }
}
