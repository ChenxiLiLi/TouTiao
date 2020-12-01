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
import com.bytedance.toutiao.ui.search.adapter.FragmentSearchFriendAdapter;
import com.bytedance.toutiao.viewmodel.SearchHotViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearchFriend extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentSearchFriendAdapter fragmentSearchFriendAdapter;
    private List<SearchHotModel> searchFriendList = new ArrayList<SearchHotModel>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_item;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentSearchFriendAdapter = new FragmentSearchFriendAdapter(getContext(),searchFriendList);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentSearchFriendAdapter);

        mViewModel = ViewModelProviders.of(getActivity()).get(SearchHotViewModel.class);
        getSearchEvent();

    }

    private void getSearchEvent() {
        ((SearchHotViewModel) mViewModel).getSearchHot("3").observe(getActivity(), new Observer<Resource<List<SearchHotModel>>>() {
            @Override
            public void onChanged(Resource<List<SearchHotModel>> listResource) {
                System.out.println("返回的资源对象是"+listResource);
                if (listResource != null) {
                    searchFriendList.addAll(listResource.data);
                    initdata();
                }
                fragmentSearchFriendAdapter.notifyDataSetChanged();
            }
        });
        Log.e("send: {}",  "发送了请求");

    }

    private void initdata() {
        SearchHotModel searchFriend1 = new SearchHotModel("大学生在校园内被狂风暴雪吹走","34534","5");
        searchFriendList.add(searchFriend1);
        SearchHotModel searchFriend2 = new SearchHotModel("华为出售荣耀","25575","6");
        searchFriendList.add(searchFriend2);
        SearchHotModel searchFriend3 = new SearchHotModel("最让人舒服的社交行为TOP1","12213","7");
        searchFriendList.add(searchFriend3);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
