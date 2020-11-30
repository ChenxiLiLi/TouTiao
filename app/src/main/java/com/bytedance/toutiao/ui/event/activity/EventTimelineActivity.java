package com.bytedance.toutiao.ui.event.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.TestViewModel;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.bean.EventOutside;
import com.bytedance.toutiao.databinding.ActivityEventTimelineBinding;
import com.bytedance.toutiao.ui.event.adapter.EventTimelineAdapter;

import java.util.ArrayList;
import java.util.List;

public class EventTimelineActivity extends BaseActivity<TestViewModel, ActivityEventTimelineBinding>  {
    private List<EventOutside> eventList= new ArrayList<EventOutside>();
    private RecyclerView recyclerView;
    private EventTimelineAdapter eventTimelineAdapter;
    private LinearLayoutManager linearLayoutManager;


    private void initevents() {
        for(int i=0;i<1;i++) {
            EventOutside event1 = new EventOutside("南昌女子被未婚夫杀害", "2020.9.10", R.mipmap.right_arrow);
            eventList.add(event1);
            EventOutside event2 = new EventOutside("死者母亲发声", "2020.9.27", R.mipmap.right_arrow);
            eventList.add(event2);
            EventOutside event3 = new EventOutside("死者闺蜜发声", "2020.9.28", R.mipmap.right_arrow);
            eventList.add(event3);
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_event_timeline;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void processLogic() {
        initevents();
        recyclerView = findViewById(R.id.event_id);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        eventTimelineAdapter = new EventTimelineAdapter(eventList, EventTimelineActivity.this);
        recyclerView.setAdapter(eventTimelineAdapter);
        //viewPager.setCurrentItem(1);



//        FragmentEventSimilar fragmentEventSimilar = new FragmentEventSimilar();
//        FragmentManager FM = getSupportFragmentManager();
//        FM.beginTransaction().replace(R.layout.activity_event_timeline, fragmentEventSimilar).commit();
    }

    @SuppressLint("ResourceType")
    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.event_buttom:
                        Toast.makeText(EventTimelineActivity.this, "进入相似事件界面", Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent(EventTimelineActivity.this, EventSimilarActivity.class);
                        startActivity(intent1);
                        break;
                }
            }
        });
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
