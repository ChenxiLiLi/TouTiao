package com.bytedance.toutiao.ui.news.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.FragmentNewsDetailBinding;
import com.bytedance.toutiao.viewmodel.NewsViewModel;


/**
 * author: Mr.Chen
 */
public class FragmentNewsDetail extends BaseFragment<NewsViewModel, FragmentNewsDetailBinding> {

    private NewsModel newsModel;
    private WebView webView;
    private ImageView ivLoading;
    private LinearLayout layoutBottom;
    public FragmentNewsDetail(){
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_news_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);
        getNewsDetail();
        webView = mContentView.findViewById(R.id.wv_content);

        webView.loadUrl("https://www.toutiao.com/a6896066770323538446/");
        ivLoading = mContentView.findViewById(R.id.iv_loading);
        layoutBottom = mContentView.findViewById(R.id.ll_comment);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                ivLoading.setVisibility(View.GONE);
                layoutBottom.setVisibility(View.VISIBLE);
            }
        });

        webView.setWebChromeClient(new WebChromeClient(){
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

    private NewsModel getNewsDetail() {
        mViewModel.newsDetail("1").observe(getActivity(), new Observer<Resource<NewsModel>>() {
            @Override
            public void onChanged(Resource<NewsModel> listResource) {
                System.out.println("返回的资源对象是"+listResource);
                if (listResource != null) {
                    newsModel = listResource.data;
                }
            }
        });

        Log.w("send: {}",  "发送了获取详情的请求");
        return newsModel;
    }

}
