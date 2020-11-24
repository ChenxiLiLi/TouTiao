package com.bytedance.toutiao.ui.user.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.FragmentMyTopicBinding;
import com.bytedance.toutiao.ui.user.adapter.MyTopicAdapter;

public class FragmentMyTopic extends BaseFragment<NormalViewModel, FragmentMyTopicBinding> {

    RecyclerView recyclerView;
    MyTopicAdapter myTopicAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_my_topic;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = binding.userRvTopic;
        myTopicAdapter = new MyTopicAdapter(getContext());
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myTopicAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
