package com.bytedance.toutiao.ui.news.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.FragmentNewsBaseBinding;
import com.bytedance.toutiao.ui.news.adapter.NewsListAdapter;
import com.bytedance.toutiao.viewmodel.NewsViewModel;
import com.bytedance.toutiao.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Mr.Chen
 */
public class FragmentNewsFollow extends BaseFragment<NewsViewModel, FragmentNewsBaseBinding> {

    private LinearLayoutManager linearLayoutManager;
    private NewsListAdapter newsListAdapter;
    private List<NewsModel> newsModels = new ArrayList<>();

    public FragmentNewsFollow() {}


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_news_base;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);
        getFollowNews();
        binding.setViewModel(mViewModel);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        //设置RecyclerView的布局
        binding.newsBase.setLayoutManager(linearLayoutManager);
        //设置资讯列表数据
        newsListAdapter = new NewsListAdapter(getActivity(), newsModels);
        binding.newsBase.setAdapter(newsListAdapter);
    }


    @Override
    protected void setListener() {
        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.e("refresh: {}",  "刷新了资讯列表");
                replaceFollowNews();
                binding.swipeRefresh.setRefreshing(false);
            }
        });

        binding.newsBase.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int lastPosition = -1;

                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if(layoutManager instanceof LinearLayoutManager){
                        lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    if(lastPosition == recyclerView.getLayoutManager().getItemCount()-1){
                        getFollowNews();
                    }

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            }

        });

    }

    @Override
    public void onClick(View view) {

    }

    private void getFollowNews(){
        mViewModel.listNews("2").observe(getActivity(), new Observer<Resource<List<NewsModel>>>() {
            @Override
            public void onChanged(Resource<List<NewsModel>> listResource) {
                System.out.println("返回的资源对象是"+listResource);
                if (listResource.state == 1) {
                    newsModels.addAll(listResource.data);
                }
                newsListAdapter.notifyDataSetChanged();
            }
        });
        Log.e("send: {}",  "发送了请求");
    }

    private void replaceFollowNews(){
        mViewModel.listNews("2").observe(getActivity(), new Observer<Resource<List<NewsModel>>>() {
            @Override
            public void onChanged(Resource<List<NewsModel>> listResource) {
                newsModels.clear();
                newsModels.addAll(listResource.data);
                newsListAdapter.notifyDataSetChanged();
                binding.newsBase.setAdapter(newsListAdapter);
            }
        });
        Log.e("load: {}",  "加载了更多列表数据");
    }

}
