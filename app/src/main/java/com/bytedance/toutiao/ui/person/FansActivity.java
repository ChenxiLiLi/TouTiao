package com.bytedance.toutiao.ui.person;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityFansBinding;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;

import java.util.ArrayList;
import java.util.List;

public class FansActivity extends BaseActivity<MessageCommentViewModel, ActivityFansBinding> {
    private List<MessageCommentModel> fans = new ArrayList<MessageCommentModel>();
    private List<MessageCommentModel> focus = new ArrayList<MessageCommentModel>();
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private FansActivityAdapter fansActivityAdapter;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_fans;
    }

    @Override
    protected void processLogic() {
        recyclerView = findViewById(R.id.item);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        fansActivityAdapter = new FansActivityAdapter(this,fans);
        recyclerView.setAdapter(fansActivityAdapter);
        mViewModel = ViewModelProviders.of(this).get(MessageCommentViewModel.class);
        String title = getIntent().getStringExtra("title");
        binding.titleName.setText(title);
        if (title.indexOf("粉丝") !=-1){
            initFans();
            getFansData();
        }
        else if (title.indexOf("关注") !=-1){
            getFocusData();
            initFocus();
        }
    }


    private void getFansData() {
        mViewModel.getMsgComment("4").observe(this, new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                System.out.println("返回的资源对象是"+listResource);
                if (listResource != null & listResource.state==1) {
                    fans.addAll(listResource.data);
                }
                fansActivityAdapter.notifyDataSetChanged();
            }
        });
        Log.e("send: {}",  "发送了请求");
    }

    private void getFocusData() {
        mViewModel.getMsgComment("5").observe(this, new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                System.out.println("返回的资源对象是"+listResource);
                if (listResource != null & listResource.state==1) {
                    fans.addAll(listResource.data);
                }
                fansActivityAdapter.notifyDataSetChanged();
            }
        });
        Log.e("send: {}",  "发送了请求");
    }

    private void initFans() {
        MessageCommentModel fan1 = new MessageCommentModel("叮当猫");
        fans.add(fan1);
        MessageCommentModel fan2 = new MessageCommentModel("咖啡猫");
        fans.add(fan2);
        MessageCommentModel fan3 = new MessageCommentModel("大雄");
        fans.add(fan3);
        MessageCommentModel fan4 = new MessageCommentModel("胖虎");
        fans.add(fan4);
        MessageCommentModel fan5 = new MessageCommentModel("基拉");
        fans.add(fan5);
        MessageCommentModel fan6 = new MessageCommentModel("怪盗基德");
        fans.add(fan6);
        MessageCommentModel fan7 = new MessageCommentModel("工藤新一");
        fans.add(fan7);
        MessageCommentModel fan8 = new MessageCommentModel("路飞");
        fans.add(fan8);
    }
    private void initFocus() {
        MessageCommentModel fan1 = new MessageCommentModel("派大星");
        fans.add(fan1);
        MessageCommentModel fan2 = new MessageCommentModel("海绵宝宝");
        fans.add(fan2);
        MessageCommentModel fan3 = new MessageCommentModel("毛利兰");
        fans.add(fan3);
        MessageCommentModel fan4 = new MessageCommentModel("犬夜叉");
        fans.add(fan4);
        MessageCommentModel fan5 = new MessageCommentModel("蜡笔小新");
        fans.add(fan5);
        MessageCommentModel fan6 = new MessageCommentModel("樱桃小丸子");
        fans.add(fan6);
        MessageCommentModel fan7 = new MessageCommentModel("懒洋洋");
        fans.add(fan7);
    }

    @Override
    protected void setListener() {
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
