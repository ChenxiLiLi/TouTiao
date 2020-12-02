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
    private String newsId;
    //private NewsDetailAdapter newsDetailAdapter;


    public FragmentNewsDetail(String newsId){
        this.newsId = newsId;
    }

    public FragmentNewsDetail() {}

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_news_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);
        getNewsDetail(newsId);

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
                    binding.wvContent.loadUrl(listResource.data.getNewsUrl());

                    binding.wvContent.setWebViewClient(new WebViewClient());
                    binding.wvContent.setWebChromeClient(new WebChromeClient());
                    WebSettings settings = binding.wvContent.getSettings();
                    //设置缩放
                    settings.setUseWideViewPort(true);
                    //设置预览模式记载界面
                    settings.setLoadWithOverviewMode(true);
                    //设置支持屏幕控件或手势进行缩放
                    settings.setSupportZoom(true);
                    settings.setJavaScriptEnabled(true);
                }
            }
        });
    }

}
