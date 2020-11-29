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
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.TopicModel;
import com.bytedance.toutiao.databinding.FragmentMyTopicBinding;
import com.bytedance.toutiao.ui.user.adapter.MyTopicAdapter;
import com.bytedance.toutiao.viewmodel.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentMyTopic extends BaseFragment<LoginViewModel, FragmentMyTopicBinding> {

    private RecyclerView recyclerView;
    private MyTopicAdapter myTopicAdapter;
    private LinearLayoutManager layoutManager;
    private List<TopicModel> topicModels = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_my_topic;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(getActivity()).get(LoginViewModel.class);
        recyclerView = binding.userRvTopic;
        myTopicAdapter = new MyTopicAdapter(getContext(), topicModels);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myTopicAdapter);
        getBaseTopic();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }

    public void getBaseTopic(){
        mViewModel.getMyTopics().observe(getActivity(), new Observer<Resource<List<TopicModel>>>() {
            @Override
            public void onChanged(Resource<List<TopicModel>> listResource) {
                if(listResource != null){
                    Log.e("userTopic", listResource.state + "");
                    Log.e("userTopic", listResource.data.size() + "");
                    topicModels.addAll(listResource.data);
                    myTopicAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
