package com.bytedance.toutiao.ui.message.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.ui.message.Activity.MessageChatActivity;
import com.bytedance.toutiao.ui.person.AuthorActivity;

public class FragmentMessageChatAdapter extends RecyclerView.Adapter<FragmentMessageChatAdapter.ViewHolder>  {

    private Context context;

    public FragmentMessageChatAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FragmentMessageChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message_detail, parent, false);
        return new FragmentMessageChatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMessageChatAdapter.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("MsgCView", view +"");
                switch (view.getId()) {
                    case R.id.item_detial:
                        Toast.makeText(context, "进入私聊界面", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, MessageChatActivity.class);
                        context.startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
