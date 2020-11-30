package com.bytedance.toutiao.ui.user.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.NewsModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.FragmentUserInfoBinding;
import com.bytedance.toutiao.ui.user.adapter.UserInfoAdapter;
import com.bytedance.toutiao.viewmodel.LoginViewModel;
import com.bytedance.toutiao.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentUserInfo extends BaseFragment<MyViewModel, FragmentUserInfoBinding> {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private UserInfoAdapter userInfoAdapter;
    private List<NewsModel> newsModels = new ArrayList<>();
    private String state;

    public FragmentUserInfo(String state) {
        this.state = state;
    }

    public FragmentUserInfo() {
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_user_info;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        recyclerView = binding.userRvInfo;
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        userInfoAdapter = new UserInfoAdapter(mContentView.getContext(), newsModels);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userInfoAdapter);
        getBaseNews();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }

    private void getBaseNews(){
        mViewModel.getMyInfos(state).observe(getActivity(), new Observer<Resource<List<NewsModel>>>() {
            @Override
            public void onChanged(Resource<List<NewsModel>> listResource) {
                if(listResource != null){
                    Log.e("userInfo", listResource.state + "");
                    Log.e("userInfo", listResource.data.size() + "");
                    newsModels.addAll(listResource.data);
                    userInfoAdapter.notifyDataSetChanged();
                }

            }
        });
    }
}
