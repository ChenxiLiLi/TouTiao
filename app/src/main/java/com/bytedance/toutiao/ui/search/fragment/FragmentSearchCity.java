package com.bytedance.toutiao.ui.search.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.SearchCityModel;
import com.bytedance.toutiao.ui.search.adapter.FragmentSearchCityAdapter;
import com.bytedance.toutiao.viewmodel.SearchCityViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearchCity extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentSearchCityAdapter fragmentSearchCityAdapter;
    private List<SearchCityModel> searchCityList = new ArrayList<SearchCityModel>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentSearchCityAdapter = new FragmentSearchCityAdapter(getContext(),searchCityList);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentSearchCityAdapter);
        mViewModel = ViewModelProviders.of(getActivity()).get(SearchCityViewModel.class);
        ((SearchCityViewModel) mViewModel).getSearchCity().observe(getActivity(), new Observer<Resource<List<SearchCityModel>>>() {
            @Override
            public void onChanged(Resource<List<SearchCityModel>> listResource) {
                initdata();
                searchCityList.addAll(listResource.data);
                fragmentSearchCityAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initdata() {
        SearchCityModel searchCity1 = new SearchCityModel("广州一高校住进\"集装箱\"？校方回应了","34534","1");
        searchCityList.add(searchCity1);
        SearchCityModel searchCity2 = new SearchCityModel("广东八旬阿伯编《雷州话字典》","24354","2");
        searchCityList.add(searchCity2);
        SearchCityModel searchCity3 = new SearchCityModel("深圳一男子被前同事刀刺身亡","11124","3");
        searchCityList.add(searchCity3);
        SearchCityModel searchCity4 = new SearchCityModel("\"交警殴打外卖小哥\"？广州警方回应","10666","4");
        searchCityList.add(searchCity4);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
