package com.bytedance.toutiao.ui.message.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.bytedance.toutiao.databinding.ItemMessageCommentBinding;
import com.bytedance.toutiao.ui.person.AuthorActivity;

import java.util.List;

public class FragmentMessageCommentAdapter extends RecyclerView.Adapter<FragmentMessageCommentAdapter.ViewHolder> {
    private Context context;
    private List<MessageCommentModel> messageCommentModels ;
    public FragmentMessageCommentAdapter(Context context, List<MessageCommentModel> messageCommentModels) {
        this.context = context;
        this.messageCommentModels = messageCommentModels;
    }

    @NonNull
    @Override
    public FragmentMessageCommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_message_comment, parent, false);
        FragmentMessageCommentAdapter.ViewHolder myHolder = new FragmentMessageCommentAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMessageCommentAdapter.ViewHolder holder, final int position) {
        ItemMessageCommentBinding binding = (ItemMessageCommentBinding) holder.getBinding();
        binding.commName.setText(messageCommentModels.get(position).getMsgCommentName());
        binding.commContent.setText(messageCommentModels.get(position).getMsgCommentContent());
        binding.commTime.setText(messageCommentModels.get(position).getMsgCommentDate());
        binding.avater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "进入作者页", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, AuthorActivity.class);
                intent.putExtra("title", messageCommentModels.get(position).getMsgCommentName());
                intent.putExtra("fansNum", messageCommentModels.get(position).getLoveNum());
                intent.putExtra("focusNum", messageCommentModels.get(position).getNum());
                intent.putExtra("content", messageCommentModels.get(position).getIntroduction());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return messageCommentModels.size();
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
