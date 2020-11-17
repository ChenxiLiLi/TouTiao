package com.bytedance.toutiao.ui.message.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.MessageCommentModel;

import java.util.List;

public class FragmentMessageCommentAdapter extends RecyclerView.Adapter<FragmentMessageCommentAdapter.ViewHolder> {
    private Context context;
    private List<MessageCommentModel> messageCommentList;

    public FragmentMessageCommentAdapter(Context context, List<MessageCommentModel> messageCommentList) {
        this.context = context;
        this.messageCommentList = messageCommentList;
    }

    @NonNull
    @Override
    public FragmentMessageCommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message_comment, parent, false);
        return new FragmentMessageCommentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMessageCommentAdapter.ViewHolder holder, int position) {
        MessageCommentModel messageComment = messageCommentList.get(position);
        holder.msgCommentUserName.setText(messageComment.getMsgCommentUserName());
        holder.msgCommentContent.setText(messageComment.getMsgCommentContent());
        holder.msgCommentDate.setText(messageComment.getMsgCommentDate());
    }

    @Override
    public int getItemCount() {
        //return 6;
        return messageCommentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //private ImageView msgCommentAvater;
        private TextView msgCommentUserName;
        private TextView msgCommentContent;
        private TextView msgCommentDate;
        //private ImageView msgCommentEventIv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //msgCommentAvater = itemView.findViewById(R.id.comm_avater);
            msgCommentUserName = itemView.findViewById(R.id.comm_name);
            msgCommentContent = itemView.findViewById(R.id.comm_content);
            msgCommentDate = itemView.findViewById(R.id.comm_time);
            //msgCommentEventIv = itemView.findViewById(R.id.comm_event);
        }
    }
}
