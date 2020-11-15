package com.bytedance.toutiao.ui.news;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.ui.news.home.NewsNowAdapter;
import com.bytedance.toutiao.ui.view.MyScrollview;

public class FragmentNewNow extends BaseFragment {

    private WebView mWvContent;
    private ImageView ivLoading;
    private LinearLayout layoutBottom;

    public FragmentNewNow(String url) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_new_now;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mWvContent = mContentView.findViewById(R.id.wv_content);

        mWvContent.loadUrl("https://www.toutiao.com/a6886776124567880196/");

        ivLoading = mContentView.findViewById(R.id.iv_loading);
        layoutBottom = mContentView.findViewById(R.id.ll_comment);

        WebSettings settings = mWvContent.getSettings();
        settings.setJavaScriptEnabled(true);
        mWvContent.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                ivLoading.setVisibility(View.GONE);
                layoutBottom.setVisibility(View.VISIBLE);
            }
        });

        mWvContent.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
            }
        });



    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }



}
