package com.bytedance.toutiao.ui.adapter.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mWvContent.loadUrl("https://www.toutiao.com/a6886776124567880196/");



        holder.scrollView.setScrollViewListener(new MyScrollview.IScrollChangedListener() {
            @Override
            public void onScrolledToBottom() {
                ToastUtils.showToast("toBottom");
            }

            @Override
            public void onScrolledToTop() {

            }
        });

        WebSettings settings = holder.mWvContent.getSettings();
        settings.setJavaScriptEnabled(true);
        holder.mWvContent.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
            }

            @Override
            public void onPageFinished(WebView view, String url) {
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
        private MyScrollview scrollView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mWvContent = itemView.findViewById(R.id.wv_content);
            scrollView = itemView.findViewById(R.id.sl_wedview);
        }
    }
}
