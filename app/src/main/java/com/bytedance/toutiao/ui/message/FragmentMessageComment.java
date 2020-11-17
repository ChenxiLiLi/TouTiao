package com.bytedance.toutiao.ui.message;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.FragmentMessageDetailBinding;
import com.bytedance.toutiao.ui.message.adapter.FragmentMessageCommentAdapter;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentMessageComment extends BaseFragment<MessageCommentViewModel, FragmentMessageDetailBinding> {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentMessageCommentAdapter fragmentMessageCommentAdapter;
    private List<MessageCommentModel> messageCommentModels = new ArrayList<MessageCommentModel>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(getActivity()).get(MessageCommentViewModel.class);
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentMessageCommentAdapter = new FragmentMessageCommentAdapter(getContext(),messageCommentModels);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(fragmentMessageCommentAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        mViewModel.getMsgComment().observe(getActivity(), new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                Log.e("message", listResource.state+ "");
                //messageCommentModels = listResource.data;
                initData();
                fragmentMessageCommentAdapter.notifyDataSetChanged();
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
    public void onClick(View view) {

    }
}
