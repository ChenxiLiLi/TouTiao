package com.bytedance.toutiao.ui.message.Fragment;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.MsgFocusModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.FragmentMessageDetailBinding;
import com.bytedance.toutiao.ui.message.adapter.FragmentMessageFocusAdapter;
import com.bytedance.toutiao.viewmodel.MsgFocusViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.bytedance.toutiao.MyApplication.getContext;

public class FragmentMessageFocus extends BaseFragment <MsgFocusViewModel, FragmentMessageDetailBinding>{
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentMessageFocusAdapter fragmentMessageFocusAdapter;
    private List<MsgFocusModel> focusModelList = new ArrayList<MsgFocusModel>();
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentMessageFocusAdapter = new FragmentMessageFocusAdapter(getContext(),focusModelList);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentMessageFocusAdapter);
        mViewModel = ViewModelProviders.of(getActivity()).get(MsgFocusViewModel.class);
        mViewModel.getMsgFocus().observe(getActivity(), new Observer<Resource<List<MsgFocusModel>>>() {
            @Override
            public void onChanged(Resource<List<MsgFocusModel>> listResource) {
                focusModelList.addAll(listResource.data);
                initData();
                fragmentMessageFocusAdapter.notifyDataSetChanged();
            }

            private void initData() {
                MsgFocusModel msgFocusModel1 = new MsgFocusModel("美国大选","2345423");
                focusModelList.add(msgFocusModel1);
            }
        });
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}