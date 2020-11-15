package com.bytedance.toutiao.ui.video.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.EventOutside;
import com.bytedance.toutiao.ui.event.EventSimilarActivity;
import com.bytedance.toutiao.ui.event.event.EventTimelineAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentVideoEvent extends BaseFragment {
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

    public static FragmentVideoEvent newFragment(){
        FragmentVideoEvent fragmentVideoEvent = new FragmentVideoEvent();
        return fragmentVideoEvent;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_video_event;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initevents();
        recyclerView = mContentView.findViewById(R.id.event_id);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        eventTimelineAdapter = new EventTimelineAdapter(eventList, getContext());
        recyclerView.setAdapter(eventTimelineAdapter);
    }

    @Override
    protected void setListener() {
        TextView textView = mContentView.findViewById(R.id.event_buttom);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.event_buttom:
                        Intent intent1 = new Intent(getContext(), EventSimilarActivity.class);
                        startActivity(intent1);
                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
