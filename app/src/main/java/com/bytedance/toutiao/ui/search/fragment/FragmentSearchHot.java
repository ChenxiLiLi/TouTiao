package com.bytedance.toutiao.ui.search.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.MsgFocusModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.SearchHotModel;
import com.bytedance.toutiao.ui.search.adapter.FragmentSearchHotAdapter;
import com.bytedance.toutiao.viewmodel.MsgFocusViewModel;
import com.bytedance.toutiao.viewmodel.SearchHotViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.bytedance.toutiao.MyApplication.getContext;

public class FragmentSearchHot extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentSearchHotAdapter fragmentSearchHotAdapter;
    private List<SearchHotModel> searchHotList = new ArrayList<SearchHotModel>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentSearchHotAdapter = new FragmentSearchHotAdapter(getContext(),searchHotList);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentSearchHotAdapter);
        mViewModel = ViewModelProviders.of(getActivity()).get(SearchHotViewModel.class);
        ((SearchHotViewModel) mViewModel).getSearchHot().observe(getActivity(), new Observer<Resource<List<SearchHotModel>>>() {
            @Override
            public void onChanged(Resource<List<SearchHotModel>> searchHotModelResource) {
                initdata();
                searchHotList.addAll(searchHotModelResource.data);
                fragmentSearchHotAdapter.notifyDataSetChanged();
            }
        });

    }

    private void initdata() {
        SearchHotModel searchHot1 = new SearchHotModel("特朗普政府官员悄悄接触拜登团队","4356767","1");
        searchHotList.add(searchHot1);
        SearchHotModel searchHot2 = new SearchHotModel("近2500名中学生贪吃蛇式跑操","234242","2");
        searchHotList.add(searchHot2);
        SearchHotModel searchHot3 = new SearchHotModel("周星驰被前女友追讨7000万案开审","23433","3");
        searchHotList.add(searchHot3);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
