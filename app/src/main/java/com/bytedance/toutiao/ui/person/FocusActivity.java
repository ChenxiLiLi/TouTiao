package com.bytedance.toutiao.ui.person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.TestViewModel;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.TopicModel;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.databinding.ActivityFansBinding;
import com.bytedance.toutiao.databinding.ActivityFocusBinding;
import com.bytedance.toutiao.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class FocusActivity extends BaseActivity<NormalViewModel, ActivityFocusBinding> {
    private List<User> focus = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FocusActivityAdapter focusActivityAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_focus;
    }

    @Override
    protected void processLogic() {
        binding.setViewModel(mViewModel);
        recyclerView = findViewById(R.id.item);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        focusActivityAdapter = new FocusActivityAdapter(this, focus);
        recyclerView.setAdapter(focusActivityAdapter);
        getFocus();
    }

    public void getFocus(){
        User focus1 = new User();
        User focus2 = new User();
        User focus3 = new User();
        focus1.setNickname("阿巴阿巴");
        focus2.setNickname("哈士奇不吃鱼");
        focus3.setNickname("没有名字");
        focus.add(focus1);
        focus.add(focus2);
        focus.add(focus3);


//        mViewModel.getMyTopics().observe(getActivity(), new Observer<Resource<List<TopicModel>>>() {
//            @Override
//            public void onChanged(Resource<List<TopicModel>> listResource) {
//                if(listResource != null){
//                    Log.e("userTopic", listResource.state + "");
//                    Log.e("userTopic", listResource.data.size() + "");
//                    topicModels.addAll(listResource.data);
//                    myTopicAdapter.notifyDataSetChanged();
//                }
//            }
//        });
    }

    @Override
    protected void setListener() {
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                switch (view.getId()){
                    case R.id.back:
                        intent = new Intent(FocusActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}