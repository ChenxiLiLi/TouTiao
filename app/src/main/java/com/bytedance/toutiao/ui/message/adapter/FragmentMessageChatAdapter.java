package com.bytedance.toutiao.ui.message.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.databinding.ItemMessageChatBinding;
import com.bytedance.toutiao.databinding.ItemMessageDetailBinding;
import com.bytedance.toutiao.ui.message.Activity.MessageChatActivity;
import com.bytedance.toutiao.ui.person.AuthorActivity;

import java.util.List;

public class FragmentMessageChatAdapter extends RecyclerView.Adapter<FragmentMessageChatAdapter.ViewHolder>  {

    private Context context;
    private List<MessageCommentModel> messageChatModels ;
    public FragmentMessageChatAdapter(Context context, List<MessageCommentModel> messageChatModels) {
        this.context = context;
        this.messageChatModels = messageChatModels;
    }
    @NonNull
    @Override
    public FragmentMessageChatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_message_detail, parent, false);
        FragmentMessageChatAdapter.ViewHolder myHolder = new FragmentMessageChatAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMessageChatAdapter.ViewHolder holder, final int position) {
        ItemMessageDetailBinding binding = (ItemMessageDetailBinding) holder.getBinding();
        binding.name.setText(messageChatModels.get(position).getMsgCommentName());
        binding.content.setText(messageChatModels.get(position).getMsgCommentContent());
        binding.itemDetial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("MsgCView", view +"");
                switch (view.getId()) {
                    case R.id.item_detial:
                        Toast.makeText(context, "进入私聊界面", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context, MessageChatActivity.class);
                        intent.putExtra("title", messageChatModels.get(position).getMsgCommentName());
                        context.startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageChatModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
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
