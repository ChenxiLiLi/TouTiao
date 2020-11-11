package com.bytedance.toutiao.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.ui.adapter.home.NewsNowAdapter;
import com.bytedance.toutiao.ui.view.MyScrollview;
import com.bytedance.toutiao.utils.ToastUtils;

public class FragmentNewNow extends BaseFragment {

    private WebView mWvContent;
    private String url;
    private MyScrollview scrollView;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private NewsNowAdapter newsNowAdapter;

    public FragmentNewNow(String url) {
        this.url = url;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_new_now;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = mContentView.findViewById(R.id.rv_news_now);

        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        newsNowAdapter = new NewsNowAdapter(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(newsNowAdapter);




    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }



}
