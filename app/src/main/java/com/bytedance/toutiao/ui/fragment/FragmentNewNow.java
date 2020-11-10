package com.bytedance.toutiao.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;

public class FragmentNewNow extends BaseFragment {

    private WebView mWvContent;
    private String url;

    public FragmentNewNow(String url) {
        this.url = url;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_new_now;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        mWvContent = mContentView.findViewById(R.id.wv_content);
        mWvContent.loadUrl(url);

        WebSettings settings = mWvContent.getSettings();
        settings.setJavaScriptEnabled(true);
        mWvContent.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
            }

            @Override
            public void onPageFinished(WebView view, String url) {
            }
        });

        mWvContent.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
            }
        });


        mWvContent.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && mWvContent.canGoBack()) {  //表示按返回键
                        mWvContent.goBack();   //后退
                        return true;    //已处理
                    }
                }
                return false;
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
