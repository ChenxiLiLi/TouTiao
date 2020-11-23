package com.bytedance.toutiao.ui.message.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.ui.message.Activity.MessageChatActivity;
import com.bytedance.toutiao.ui.message.adapter.FragmentMessageChatAdapter;

public class FragmentMessageChat extends BaseFragment
{

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentMessageChatAdapter fragmentMessageChatAdapter;
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentMessageChatAdapter = new FragmentMessageChatAdapter(getContext());
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentMessageChatAdapter);

    }

    @Override
    protected void setListener() {
    }

    @Override
    public void onClick(View view) {
    }
}
