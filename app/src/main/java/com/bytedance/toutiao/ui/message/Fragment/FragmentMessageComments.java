package com.bytedance.toutiao.ui.message.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.bytedance.toutiao.databinding.FragmentMessageItemBinding;
import com.bytedance.toutiao.ui.login.LoginActivity;
import com.bytedance.toutiao.ui.message.adapter.FragmentMessageCommentAdapter;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentMessageComments extends BaseFragment<MessageCommentViewModel, FragmentMessageItemBinding> {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentMessageCommentAdapter fragmentMessageCommentAdapter;
    private List<MessageCommentModel> messageCommentModels = new ArrayList<MessageCommentModel>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_item;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(getActivity()).get(MessageCommentViewModel.class);
        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        if(null == (sp.getString("username", null)))
            binding.rvToLogin.setVisibility(View.VISIBLE);
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentMessageCommentAdapter = new FragmentMessageCommentAdapter(getContext(),messageCommentModels);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(fragmentMessageCommentAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        getdata();
    }

    private void getdata() {
        mViewModel.getMsgComment("1").observe(getActivity(), new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                System.out.println("返回的资源对象是"+listResource);
                if (listResource != null & listResource.state==1) {
                    messageCommentModels.addAll(listResource.data);
                }
                initData();
                fragmentMessageCommentAdapter.notifyDataSetChanged();
            }
        });
        Log.e("send: {}",  "发送了请求");
    }

    private void initData(){
        MessageCommentModel msgcomm1 = new MessageCommentModel("小哪吒","评论内容～","2月30日 19:00");
        messageCommentModels.add(msgcomm1);
        MessageCommentModel msgcomm2 = new MessageCommentModel("葫芦娃","评论内容～","2月30日 19:00");
        messageCommentModels.add(msgcomm2);
        MessageCommentModel msgcomm3 = new MessageCommentModel("黑猫警长","评论内容～","2月30日 19:00");
        messageCommentModels.add(msgcomm3);
    }

    @Override
    protected void setListener() {
        binding.btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(toLogin);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
