package com.bytedance.toutiao.ui.message.fragment;

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
    private List<MessageCommentModel> messageCommentModels = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initData();
        mViewModel = ViewModelProviders.of(getActivity()).get(MessageCommentViewModel.class);
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentMessageCommentAdapter = new FragmentMessageCommentAdapter(getContext(), messageCommentModels);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentMessageCommentAdapter);

        mViewModel.getMsgComment().observe(getActivity(), new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                messageCommentModels.addAll(listResource.data);
                fragmentMessageCommentAdapter.notifyDataSetChanged();
            }
        });



    }
    private void initData(){
        MessageCommentModel messageCommentModel = new MessageCommentModel();
        messageCommentModel.setMsgCommentContent("你爱我是谁");
        messageCommentModel.setMsgCommentUserName("天外来物");
        messageCommentModels.add(messageCommentModel);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
