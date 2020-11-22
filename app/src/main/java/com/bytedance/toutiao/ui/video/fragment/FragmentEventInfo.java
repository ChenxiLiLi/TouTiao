package com.bytedance.toutiao.ui.video.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.FragmentUserInfoBinding;
import com.bytedance.toutiao.databinding.FragmentVideoEventInfoBinding;
import com.bytedance.toutiao.ui.news.adapter.NewsListAdapter;
import com.bytedance.toutiao.ui.user.adapter.UserInfoAdapter;
import com.bytedance.toutiao.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentEventInfo extends BaseFragment<NewsViewModel, FragmentVideoEventInfoBinding> {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private NewsListAdapter newsListAdapter;
    private List<NewsModel> newsModels = new ArrayList<>();
    private String eventId;

    public FragmentEventInfo(String eventId) {
        this.eventId = eventId;
    }

    public FragmentEventInfo() {
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_video_event_info;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);
        getBaseNews();
        recyclerView = binding.userRvInfo;
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        newsListAdapter = new NewsListAdapter(mContentView.getContext(),newsModels);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(newsListAdapter);
    }

    @Override
    protected void setListener() {

    }
    private void getBaseNews(){
        mViewModel.listNews("1").observe(getActivity(), new Observer<Resource<List<NewsModel>>>() {
            @Override
            public void onChanged(Resource<List<NewsModel>> listResource) {

                if (listResource.state != 1) {
                    Log.e("send: {}",  "请求失败");
                    return;
                }
                newsModels.addAll(listResource.data);
                newsListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}

