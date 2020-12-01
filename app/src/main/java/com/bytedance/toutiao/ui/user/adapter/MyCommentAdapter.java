package com.bytedance.toutiao.ui.user.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyCommentAdapter extends RecyclerView.Adapter<MyCommentAdapter.ViewHolder> {

    private Context context;
    private List<MessageCommentModel> messageCommentModels;

    public MyCommentAdapter(Context context, List<MessageCommentModel> messageCommentModels){
        this.context = context;
        this.messageCommentModels = messageCommentModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_my_comment, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageCommentModel model = messageCommentModels.get(position);
        holder.nickname.setText(model.getMsgCommentUserName());
        holder.content.setText(model.getMsgCommentContent());
        holder.time.setText(model.getMsgCommentDate());
    }

    @Override
    public int getItemCount() {
        Log.e("CommentCount", String.valueOf(messageCommentModels.size()));
        return messageCommentModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nickname;
        private TextView content;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nickname = itemView.findViewById(R.id.my_comment_name);
            content = itemView.findViewById(R.id.my_comment_content);
            time = itemView.findViewById(R.id.my_comment_time);
        }
    }
}
