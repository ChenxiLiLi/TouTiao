package com.bytedance.toutiao.ui.person;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.TestViewModel;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.MessageChatModel;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.databinding.ActivityEventSimilarBinding;
import com.bytedance.toutiao.databinding.ActivityFansBinding;
import com.bytedance.toutiao.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class FansActivity extends BaseActivity<TestViewModel, ActivityFansBinding> {
    private List<MessageCommentModel> fans = new ArrayList<MessageCommentModel>();
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
        init();
    }

    private void init() {
        MessageCommentModel fan1 = new MessageCommentModel("叮当猫");
        fans.add(fan1);
        MessageCommentModel fan2 = new MessageCommentModel("咖啡猫");
        fans.add(fan2);
        MessageCommentModel fan3 = new MessageCommentModel("大雄");
        fans.add(fan3);
        MessageCommentModel fan4 = new MessageCommentModel("胖虎");
        fans.add(fan4);
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
