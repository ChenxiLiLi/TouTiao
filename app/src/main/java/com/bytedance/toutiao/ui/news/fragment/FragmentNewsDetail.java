package com.bytedance.toutiao.ui.news.fragment;

import android.content.Intent;
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
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.ui.news.adapter.NewsDetailAdapter;
import com.bytedance.toutiao.ui.view.CommentDialog;
import com.bytedance.toutiao.ui.view.media.NestRecyclerView;
import com.bytedance.toutiao.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * author: Mr.Chen
 */
public class FragmentNewsDetail extends BaseFragment<NewsViewModel, FragmentNewsDetailBinding> {

    private List<NewsModel> newsModels = new ArrayList<>();
    private WebView webView;
    private ImageView ivLoading;
    private LinearLayout layoutBottom;
    private String newsId;
    private NewsDetailAdapter newsDetailAdapter;


    public FragmentNewsDetail(String newsId){
        this.newsId = newsId;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_news_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);
        getNewsDetail(newsId);
        newsDetailAdapter = new NewsDetailAdapter(getActivity(), getResources(), newsModels);
        ivLoading = mContentView.findViewById(R.id.iv_loading);
        layoutBottom = mContentView.findViewById(R.id.ll_comment);

        webView = mContentView.findViewById(R.id.wv_content);
        webView.setWebViewClient(new WebViewClient());

        WebSettings settings = webView.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setJavaScriptEnabled(true);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }

    private void getNewsDetail(String id) {


        System.out.println("请求的参数id是"+ id);

        mViewModel.newsDetail(id).observe(getActivity(), new Observer<Resource<NewsModel>>() {
            @Override
            public void onChanged(Resource<NewsModel> listResource) {
                System.out.println("返回的资源对象是"+listResource);

                if (listResource.state == 1) {
                    newsModels.add(listResource.data);
                    webView.loadUrl(listResource.data.getNewsUrl());
                }
                newsDetailAdapter.notifyDataSetChanged();
            }
        });
    }

}
