package com.bytedance.toutiao.ui.user.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityMyTopicBinding;
import com.bytedance.toutiao.ui.user.adapter.MyTopicAdapter;

import static com.bytedance.toutiao.MyApplication.getContext;

public class MyTopicActivity extends BaseActivity<NormalViewModel, ActivityMyTopicBinding> {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MyTopicAdapter myTopicAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_topic;
    }

    @Override
    protected void processLogic() {
        recyclerView = binding.myTopicRv;
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        myTopicAdapter = new MyTopicAdapter(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myTopicAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_topic);
    }
}
