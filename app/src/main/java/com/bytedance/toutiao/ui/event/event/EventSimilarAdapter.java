package com.bytedance.toutiao.ui.event.event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.EventOutside;

import java.util.List;

public class EventSimilarAdapter extends RecyclerView.Adapter<EventSimilarAdapter.ViewHolder> {
    private List<EventOutside> eventSimilarOutsides;
    private Context context;

    public EventSimilarAdapter(List<EventOutside> eventSimilarOutsides, Context context) {
        this.eventSimilarOutsides = eventSimilarOutsides;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EventOutside eventOutside = eventSimilarOutsides.get(position);
        holder.titleView.setText(eventOutside.getTitle());
        holder.dateaView.setText(eventOutside.getDate());
        holder.entericView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventSimilarOutsides.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleView;
        private TextView dateaView;
        private ImageView entericView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.event_title);
            dateaView = itemView.findViewById(R.id.event_date);
            entericView = itemView.findViewById(R.id.event_enteric);
        }
    }


}
