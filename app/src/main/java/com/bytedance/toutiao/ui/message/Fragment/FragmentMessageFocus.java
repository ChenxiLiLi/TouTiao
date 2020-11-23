package com.bytedance.toutiao.ui.message.Fragment;

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
import com.bytedance.toutiao.bean.MsgFocusModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.FragmentMessageDetailBinding;
import com.bytedance.toutiao.ui.message.adapter.FragmentMessageFocusAdapter;
import com.bytedance.toutiao.viewmodel.MsgFocusViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentMessageFocus extends BaseFragment<MsgFocusViewModel, FragmentMessageDetailBinding>  {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentMessageFocusAdapter fragmentMessageFocusAdapter;
    private List<MsgFocusModel> msgFocusList = new ArrayList<MsgFocusModel>();
    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentMessageFocusAdapter = new FragmentMessageFocusAdapter(getContext(),msgFocusList);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentMessageFocusAdapter);
        mViewModel = ViewModelProviders.of(getActivity()).get(MsgFocusViewModel.class);
        mViewModel.getMsgFocus().observe(getActivity(), new Observer<Resource<List<MsgFocusModel>>>() {
            @Override
            public void onChanged(Resource<List<MsgFocusModel>> listResource) {
                msgFocusList.addAll(listResource.data);
                initData();
                fragmentMessageFocusAdapter.notifyDataSetChanged();
            }

            private void initData() {
                MsgFocusModel msg1 = new MsgFocusModel("美国大选","3540532");
                msgFocusList.add(msg1);
                MsgFocusModel msg2 = new MsgFocusModel("肺炎疫情","99999999");
                msgFocusList.add(msg2);
                MsgFocusModel msg3 = new MsgFocusModel("周深工作室","23432");
                msgFocusList.add(msg3);

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
