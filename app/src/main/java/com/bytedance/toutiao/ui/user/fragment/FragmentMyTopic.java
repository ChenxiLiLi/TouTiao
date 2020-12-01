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
import com.bytedance.toutiao.viewmodel.MyViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentMyTopic extends BaseFragment<MyViewModel, FragmentMyTopicBinding> {

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
        mViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        recyclerView = binding.userRvTopic;
        myTopicAdapter = new MyTopicAdapter(getContext(), topicModels);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myTopicAdapter);
        initTopic();
        getBaseTopic();
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }

    public void initTopic(){
        TopicModel topic1 = new TopicModel();
        TopicModel topic2 = new TopicModel();
        TopicModel topic3 = new TopicModel();
        TopicModel topic4 = new TopicModel();
        topic1.setTopicName("特朗普称要离开白宫");
        topic2.setTopicName("外交部呼吁彻查澳军虐杀暴行");
        topic3.setTopicName("兰州规定不得要求家长代批作业");
        topic4.setTopicName("外卖小哥火海中救人获评见义勇为");
        topicModels.add(topic1);
        topicModels.add(topic2);
        topicModels.add(topic3);
        topicModels.add(topic4);
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
