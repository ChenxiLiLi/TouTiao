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
import com.bytedance.toutiao.ui.message.adapter.FragmentMessageFocusAdapter;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentMessageFocus extends BaseFragment <MessageCommentViewModel, FragmentMessageItemBinding>{
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentMessageFocusAdapter fragmentMessageFocusAdapter;
    private List<MessageCommentModel> focusModelList = new ArrayList<MessageCommentModel>();
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_item;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentMessageFocusAdapter = new FragmentMessageFocusAdapter(getContext(),focusModelList);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentMessageFocusAdapter);
        mViewModel = ViewModelProviders.of(getActivity()).get(MessageCommentViewModel.class);
        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        if(null == (sp.getString("username", null)))
            binding.rvToLogin.setVisibility(View.VISIBLE);
        getdata();
    }

    private void getdata() {
        mViewModel.getMsgComment("2").observe(getActivity(), new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                System.out.println("返回的资源对象是"+listResource);
                if (listResource != null & listResource.state==1) {
                    focusModelList.addAll(listResource.data);
                }
                initData();
                fragmentMessageFocusAdapter.notifyDataSetChanged();
            }
        });
        Log.e("send: {}",  "发送了请求");
    }

    private void initData() {
        MessageCommentModel msgFocusModel1 = new MessageCommentModel("美国大选","2345423");
        focusModelList.add(msgFocusModel1);
        MessageCommentModel msgFocusModel2 = new MessageCommentModel("家里那些事儿","67664");
        focusModelList.add(msgFocusModel2);
        MessageCommentModel msgFocusModel3 = new MessageCommentModel("娱乐八卦阵","3452345");
        focusModelList.add(msgFocusModel3);
        MessageCommentModel msgFocusModel4 = new MessageCommentModel("互联网金融","787892");
        focusModelList.add(msgFocusModel4);
        MessageCommentModel msgFocusModel5 = new MessageCommentModel("手机行业精选","56357");
        focusModelList.add(msgFocusModel5);
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