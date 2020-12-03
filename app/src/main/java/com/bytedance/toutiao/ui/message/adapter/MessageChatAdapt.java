package com.bytedance.toutiao.ui.message.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.MessageChatModel;
import com.bytedance.toutiao.databinding.ItemMessageChatBinding;
import com.bytedance.toutiao.databinding.ItemMessageFocusBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.ui.person.AuthorActivity;

import java.util.List;

public class MessageChatAdapt extends RecyclerView.Adapter <MessageChatAdapt.ViewHolder> {
    private List<MessageChatModel> msglist;
    private Context context;
    private String title;
    private String myName;

    public MessageChatAdapt(List<MessageChatModel> msglist, Context context, String title) {
        this.msglist = msglist;
        this.context = context;
        this.title = title;
    }

    @NonNull
    @Override
    public MessageChatAdapt.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_message_chat, parent, false);
        MessageChatAdapt.ViewHolder myHolder = new MessageChatAdapt.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageChatAdapt.ViewHolder holder, int position) {
        final ItemMessageChatBinding binding = (ItemMessageChatBinding) holder.getBinding();
        SharedPreferences sp = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        myName = sp.getString("username","username");
        MessageChatModel msg = msglist.get(position);
        switch (msg.getType()){
            case MessageChatModel.TYPE_SENT:
                binding.chatRight.setVisibility(View.VISIBLE);
                binding.chatLeft.setVisibility(View.GONE);
                binding.textChatRight.setText(msg.getContent());
                break;
            case MessageChatModel.TYPE_RECEIVED:
                binding.chatLeft.setVisibility(View.VISIBLE);
                binding.chatRight.setVisibility(View.GONE);
                binding.textChatLeft.setText(msg.getContent());
                break;
        }
        binding.messageRightAvater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "进入作者页", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, AuthorActivity.class);
                intent.putExtra("title", myName);
                context.startActivity(intent);
            }
        });
        binding.messageLeftAvater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "进入作者页", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, AuthorActivity.class);
                intent.putExtra("title", title);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return msglist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;
        public ViewDataBinding getBinding(){
            return binding;
        }

        public void setBinding(ViewDataBinding binding){
            this.binding = binding;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
