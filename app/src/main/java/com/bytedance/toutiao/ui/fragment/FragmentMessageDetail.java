package com.bytedance.toutiao.ui.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.ui.adapter.MessageDetailAdapter;
import com.bytedance.toutiao.ui.adapter.PostDetailAdapter;

import static com.bytedance.toutiao.MyApplication.getContext;

public class FragmentMessageDetail extends BaseFragment
{

    private RecyclerView recyclerView;
    private MessageDetailAdapter messageDetailAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        messageDetailAdapter = new MessageDetailAdapter(getContext());
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(messageDetailAdapter);

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
