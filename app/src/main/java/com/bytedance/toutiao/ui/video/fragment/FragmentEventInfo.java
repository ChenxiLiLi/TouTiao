package com.bytedance.toutiao.ui.video.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.FragmentUserInfoBinding;
import com.bytedance.toutiao.databinding.FragmentVideoEventInfoBinding;
import com.bytedance.toutiao.ui.user.adapter.UserInfoAdapter;

public class FragmentEventInfo extends BaseFragment<NormalViewModel, FragmentVideoEventInfoBinding> {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private UserInfoAdapter userInfoAdapter;
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
        recyclerView = binding.userRvInfo;
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        userInfoAdapter = new UserInfoAdapter(mContentView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userInfoAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}

