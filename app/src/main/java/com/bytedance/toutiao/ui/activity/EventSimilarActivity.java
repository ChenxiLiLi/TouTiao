package com.bytedance.toutiao.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.TestViewModel;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.EventOutside;
import com.bytedance.toutiao.databinding.ActivityEventSimilarBinding;
import com.bytedance.toutiao.databinding.ActivityEventTimelineBinding;
import com.bytedance.toutiao.ui.adapter.event.EventSimilarAdapter;
import com.bytedance.toutiao.ui.adapter.event.EventTimelineAdapter;

import java.util.ArrayList;
import java.util.List;

public class EventSimilarActivity extends BaseActivity<TestViewModel, ActivityEventSimilarBinding> {
    private List<EventOutside> eventList= new ArrayList<EventOutside>();
    private RecyclerView recyclerView;
    private EventSimilarAdapter eventSimilarAdapter;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_event_similar;
    }

    @Override
    protected void processLogic() {
        initevents();
        recyclerView = findViewById(R.id.event_id);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        eventSimilarAdapter = new EventSimilarAdapter(eventList, EventSimilarActivity.this);
        recyclerView.setAdapter(eventSimilarAdapter);

    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.return_similar_event:
                        Toast.makeText(EventSimilarActivity.this, "返回事件时间轴界面", Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent(EventSimilarActivity.this, EventTimelineActivity.class);
                        startActivity(intent1);
                        break;
                }
            }
        });

    }

    private void initevents() {
        for(int i=0;i<2;i++) {
            EventOutside event1 = new EventOutside("杭州来姓女子失踪案", "2019.10.7", R.mipmap.right_arrow);
            eventList.add(event1);
            EventOutside event2 = new EventOutside("南京杀妻碎尸案", "2019.5.6", R.mipmap.right_arrow);
            eventList.add(event2);
            EventOutside event3 = new EventOutside("江西女子退婚后被杀害", "2019.3.4", R.mipmap.right_arrow);
            eventList.add(event3);
            EventOutside event4 = new EventOutside("安徽一女子被当街杀害", "2019.2.1", R.mipmap.right_arrow);
            eventList.add(event4);
        }
    }

}
