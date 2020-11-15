package com.bytedance.toutiao.ui.message.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.MessageChatModel;

import java.util.List;

public class MessageChatAdapt extends RecyclerView.Adapter <MessageChatAdapt.ViewHolder> {
    private List<MessageChatModel> msglist;
    private Context context;

    public MessageChatAdapt(List<MessageChatModel> msglist, Context context) {
        this.msglist = msglist;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageChatAdapt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message_chat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageChatAdapt.ViewHolder holder, int position) {
        MessageChatModel msg = msglist.get(position);
//        switch (msg.getType()){
//            case MessageChatModel.TYPE_SENT:
//                holder.rightLayout.setVisibility(View.VISIBLE);
//                holder.leftLayout.setVisibility(View.GONE);
//                holder.rightmsg.setText(msg.getContent());
//                break;
//            case MessageChatModel.TYPE_RECEIVED:
//                holder.leftLayout.setVisibility(View.VISIBLE);
//                holder.rightLayout.setVisibility(View.GONE);
//                holder.leftmsg.setText(msg.getContent());
//                break;
//        }
        if (msg.getType() == MessageChatModel.TYPE_SENT){
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightmsg.setText(msg.getContent());
        } else
            if(msg.getType() == MessageChatModel.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftmsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return msglist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout leftLayout;
        RelativeLayout rightLayout;
        TextView leftmsg;
        TextView rightmsg;
        @SuppressLint("WrongViewCast")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leftLayout = (RelativeLayout) itemView.findViewById(R.id.chat_left);
            rightLayout = (RelativeLayout) itemView.findViewById(R.id.chat_right);
            leftmsg = (TextView) itemView.findViewById(R.id.text_chat_left);
            rightmsg = (TextView) itemView.findViewById(R.id.text_chat_right);
        }
    }
}
