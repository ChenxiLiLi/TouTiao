package com.bytedance.toutiao.ui.user.activity;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityMyCommentBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.ui.message.adapter.FragmentMessageCommentAdapter;
import com.bytedance.toutiao.ui.user.adapter.MyCommentAdapter;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.bytedance.toutiao.MyApplication.getContext;

public class MyCommentActivity extends BaseActivity<MessageCommentViewModel, ActivityMyCommentBinding> {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MyCommentAdapter myCommentAdapter;
    private List<MessageCommentModel> messageCommentModels = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_comment;
    }

    @Override
    protected void processLogic() {
        initData();
        binding.setViewModel(mViewModel);
        recyclerView = binding.rvMyComment;
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        myCommentAdapter = new MyCommentAdapter(getContext(), messageCommentModels);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myCommentAdapter);

    }

    private void initData(){
        MessageCommentModel msgcomm1 = new MessageCommentModel("用户名1","评论内容～","2月30日 19:00");
        messageCommentModels.add(msgcomm1);
        MessageCommentModel msgcomm2 = new MessageCommentModel("用户名2","评论内容～","2月30日 19:00");
        messageCommentModels.add(msgcomm2);
        MessageCommentModel msgcomm3 = new MessageCommentModel("用户名3","评论内容～","2月30日 19:00");
        messageCommentModels.add(msgcomm3);

        mViewModel.getMsgComment().observe(this, new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                Log.e("userComment", listResource.state + "");
                Log.e("userComment", listResource.data.size() + "");
                messageCommentModels.addAll(listResource.data);
                myCommentAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (view.getId()){
                    case R.id.my_back:
                        intent = new Intent(MyCommentActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
