package com.bytedance.toutiao.ui.user.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.VideoModel;
import com.bytedance.toutiao.ui.video.activity.VideoDetailActivity;

import java.util.List;

public class UserVideoAdapter extends RecyclerView.Adapter<UserVideoAdapter.ViewHolder> {

    private Context context;
    private List<VideoModel> videoModels;

    public UserVideoAdapter(Context context, List<VideoModel> videoModels) {
        this.context = context;
        this.videoModels = videoModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_focus_video, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideoDetailActivity.class);
                intent.putExtra("videoID", videoModels.get(position).getVideoId());
                context.startActivity(intent);
            }
        });
        holder.localPic.setImageResource(videoModels.get(position).getImgId());
        holder.tvPublisherName.setText(videoModels.get(position).getAuthorName());
        holder.tvContent.setText(videoModels.get(position).getContent());
        holder.tvLoveNum.setText(videoModels.get(position).getLoveNum());
        holder.tvCommentNum.setText(videoModels.get(position).getCommentNum());
    }

    @Override
    public int getItemCount() {
        return videoModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView localPic;
        private TextView tvPublisherName;
        private TextView tvContent;
        private TextView tvLoveNum;
        private TextView tvCommentNum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            localPic = itemView.findViewById(R.id.iv_local_pic2);
            tvPublisherName = itemView.findViewById(R.id.publisher_name);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvLoveNum = itemView.findViewById(R.id.tv_love_num);
            tvCommentNum = itemView.findViewById(R.id.tv_comment_num);
        }
    }
}