package com.bytedance.toutiao.ui.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityMyCommentBinding;
import com.bytedance.toutiao.ui.user.adapter.MyCommentAdapter;

import static com.bytedance.toutiao.MyApplication.getContext;

public class MyCommentActivity extends BaseActivity<NormalViewModel, ActivityMyCommentBinding> {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MyCommentAdapter myCommentAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_comment;
    }

    @Override
    protected void processLogic() {
        recyclerView = binding.rvMyComment;
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        myCommentAdapter = new MyCommentAdapter(getContext());
        recyclerView.setAdapter(myCommentAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_comment);
    }
}
