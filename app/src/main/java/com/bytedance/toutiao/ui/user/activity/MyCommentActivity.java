package com.bytedance.toutiao.ui.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityMyCommentBinding;
import com.bytedance.toutiao.ui.user.adapter.MyCommentAdapter;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.bytedance.toutiao.MyApplication.getContext;

public class MyCommentActivity extends BaseActivity<MessageCommentViewModel, ActivityMyCommentBinding> {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MyCommentAdapter myCommentAdapter;
    private List<MessageCommentModel> messageCommentModels = new ArrayList<MessageCommentModel>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_comment;
    }

    @Override
    protected void processLogic() {
        binding.setViewModel(mViewModel);
        recyclerView = binding.rvMyComment;
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        myCommentAdapter = new MyCommentAdapter(getContext(), messageCommentModels);
        recyclerView.setAdapter(myCommentAdapter);
        recyclerView.setLayoutManager(layoutManager);
        mViewModel.getMsgComment("1").observe(this, new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                messageCommentModels.addAll(listResource.data);
                initData();
                myCommentAdapter.notifyDataSetChanged();
            }
        });

    }



    private void initData(){
        MessageCommentModel msgcomm1 = new MessageCommentModel("用户名1","评论内容～","2月30日 19:00");
        messageCommentModels.add(msgcomm1);
        MessageCommentModel msgcomm2 = new MessageCommentModel("用户名2","评论内容～","2月30日 19:00");
        messageCommentModels.add(msgcomm2);
        MessageCommentModel msgcomm3 = new MessageCommentModel("用户名3","评论内容～","2月30日 19:00");
        messageCommentModels.add(msgcomm3);
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
