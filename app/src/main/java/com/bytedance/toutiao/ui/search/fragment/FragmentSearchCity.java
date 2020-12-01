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
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.SearchHotModel;
import com.bytedance.toutiao.ui.search.adapter.FragmentSearchCityAdapter;
import com.bytedance.toutiao.viewmodel.SearchHotViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearchCity extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentSearchCityAdapter fragmentSearchCityAdapter;
    private List<SearchHotModel> searchCityList = new ArrayList<SearchHotModel>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_item;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentSearchCityAdapter = new FragmentSearchCityAdapter(getContext(),searchCityList);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentSearchCityAdapter);
        mViewModel = ViewModelProviders.of(getActivity()).get(SearchHotViewModel.class);
        getSearchEvent();

    }

    private void getSearchEvent() {
        ((SearchHotViewModel) mViewModel).getSearchHot("2").observe(getActivity(), new Observer<Resource<List<SearchHotModel>>>() {
            @Override
            public void onChanged(Resource<List<SearchHotModel>> listResource) {
                System.out.println("返回的资源对象是"+listResource);
                if (listResource != null) {
                    searchCityList.addAll(listResource.data);
                    initdata();
                }
                fragmentSearchCityAdapter.notifyDataSetChanged();
            }
        });
        Log.e("send: {}",  "发送了请求");

    }

    private void initdata() {
        SearchHotModel searchCity1 = new SearchHotModel("广州一高校住进\"集装箱\"？校方回应了","34534","5");
        searchCityList.add(searchCity1);
        SearchHotModel searchCity2 = new SearchHotModel("广东八旬阿伯编《雷州话字典》","24354","6");
        searchCityList.add(searchCity2);
        SearchHotModel searchCity3 = new SearchHotModel("深圳一男子被前同事刀刺身亡","11124","7");
        searchCityList.add(searchCity3);
        SearchHotModel searchCity4 = new SearchHotModel("\"交警殴打外卖小哥\"？广州警方回应","10666","8");
        searchCityList.add(searchCity4);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
