package com.bytedance.toutiao.ui.user.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.FragmentFansBinding;
import com.bytedance.toutiao.ui.user.adapter.FocusUserAdapter;

public class FragmentFans extends BaseFragment<NormalViewModel, FragmentFansBinding> {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private FocusUserAdapter focusUserAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_fans;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = binding.fansRv;
        focusUserAdapter = new FocusUserAdapter(getContext());
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(focusUserAdapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
