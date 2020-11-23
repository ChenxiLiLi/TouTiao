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
import com.bytedance.toutiao.bean.SearchFriendModel;
import com.bytedance.toutiao.ui.search.adapter.FragmentSearchFriendAdapter;
import com.bytedance.toutiao.viewmodel.SearchFriendViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentSearchFriend extends BaseFragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FragmentSearchFriendAdapter fragmentSearchFriendAdapter;
    private List<SearchFriendModel> searchFriendList = new ArrayList<SearchFriendModel>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        recyclerView = mContentView.findViewById(R.id.rv_message_detail);
        fragmentSearchFriendAdapter = new FragmentSearchFriendAdapter(getContext(),searchFriendList);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fragmentSearchFriendAdapter);

        mViewModel = ViewModelProviders.of(getActivity()).get(SearchFriendViewModel.class);
        ((SearchFriendViewModel) mViewModel).getSearchFriend().observe(getActivity(), new Observer<Resource<List<SearchFriendModel>>>() {
            @Override
            public void onChanged(Resource<List<SearchFriendModel>> searchFriendModelResource) {
                initdata();
                searchFriendList.addAll(searchFriendModelResource.data);
                fragmentSearchFriendAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initdata() {
        SearchFriendModel searchFriend1 = new SearchFriendModel("大学生在校园内被狂风暴雪吹走","34534","1");
        searchFriendList.add(searchFriend1);
        SearchFriendModel searchFriend2 = new SearchFriendModel("华为出售荣耀","25575","2");
        searchFriendList.add(searchFriend2);
        SearchFriendModel searchFriend3 = new SearchFriendModel("最让人舒服的社交行为TOP1","12213","3");
        searchFriendList.add(searchFriend3);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
}
