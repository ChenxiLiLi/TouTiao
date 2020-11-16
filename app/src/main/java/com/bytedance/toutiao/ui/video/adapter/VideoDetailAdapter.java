package com.bytedance.toutiao.ui.video.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.toutiao.R;
import com.bytedance.toutiao.ui.video.activity.TopicSquareActivity;
import com.bytedance.toutiao.ui.view.CommentDialog;
import com.bytedance.toutiao.ui.view.VideoLoadingProgressbar;
import com.bytedance.toutiao.ui.view.VideoPlayer;
import com.bytedance.toutiao.ui.view.media.VideoPlayAdapter;

import java.io.IOException;

public class VideoDetailAdapter extends VideoPlayAdapter<VideoDetailAdapter.ViewHolder> {

    private Context mContext;

    private int mCurrentPosition;
    private ViewHolder mCurrentHolder;
    private Resources resources;
    private VideoPlayer videoPlayer;
    private TextureView textureView;
    private String videoID;
    private int resid ;
    private View.OnClickListener listener;

    public VideoDetailAdapter(Context mContext, Resources resources, String videoID, View.OnClickListener listener) {
        this.listener = listener;
        this.mContext = mContext;
        videoPlayer = new VideoPlayer();
        textureView = new TextureView(mContext);
        videoPlayer.setTextureView(textureView);
        this.resources = resources;
        this.videoID = videoID;
        switch (videoID){
            case "3":
                resid = R.mipmap.local_pic3;
                break;
            case "2":
                resid = R.mipmap.local_pic2;
                break;
            case "1":
                resid = R.mipmap.local_pic1;
                break;
        }
    }


    public VideoDetailAdapter(Context mContext, Resources resources, String videoID) {
        this.mContext = mContext;
        videoPlayer = new VideoPlayer();
        textureView = new TextureView(mContext);
        videoPlayer.setTextureView(textureView);
        this.resources = resources;
        this.videoID = videoID;
        switch (videoID){
            case "3":
                resid = R.mipmap.local_pic3;
                break;
            case "2":
                resid = R.mipmap.local_pic2;
                break;
            case "1":
                resid = R.mipmap.local_pic1;
                break;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext).load(resid).apply(options).into(holder.ivCover);
//        holder.ivComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                Intent intent = new Intent(mContext, TopicSquareActivity.class);
////                mContext.startActivity(intent);
//            }
//        });
        holder.ivComment.setOnClickListener(listener);
        holder.flVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoPlayer.pause();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onPageSelected(int itemPosition, View itemView) {
        mCurrentPosition = itemPosition;
        mCurrentHolder = new ViewHolder(itemView);
        playVideo();
    }

    private void playVideo() {
        videoPlayer.reset();
        mCurrentHolder.pbLoading.setVisibility(View.VISIBLE);
        videoPlayer.setOnStateChangeListener(new VideoPlayer.OnStateChangeListener() {
            @Override
            public void onReset() {
                mCurrentHolder.ivCover.setVisibility(View.VISIBLE);
                mCurrentHolder.pbLoading.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onRenderingStart() {
                mCurrentHolder.ivCover.setVisibility(View.GONE);
                mCurrentHolder.pbLoading.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onProgressUpdate(float per) {
            }

            @Override
            public void onPause() {
                mCurrentHolder.pbLoading.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onStop() {
                mCurrentHolder.ivCover.setVisibility(View.VISIBLE);
                mCurrentHolder.pbLoading.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onComplete() {
                videoPlayer.start();
            }
        });
        if (textureView.getParent() != mCurrentHolder.flVideo) {
            //已经添加过就移除
            if (textureView.getParent() != null) {
                ((FrameLayout) textureView.getParent()).removeView(textureView);
            }
            mCurrentHolder.flVideo.addView(textureView);
        }
        //加载assets文件夹下的视频资源
        AssetFileDescriptor afd = null;
        try {
            afd = resources.getAssets().openFd("local_video" + videoID +".mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
        videoPlayer.setDataSource(afd);
//        videoPlayer.setDataSource("https://txmov2.a.yximgs.com/bs2/newWatermark/MjczMzU3NDA0ODU_zh_3.mp4");
        videoPlayer.prepare();
    }

    public void release() {
        videoPlayer.release();
    }

    public void stop(){videoPlayer.stop();}

    public void pause(){videoPlayer.pause();}

    class ViewHolder extends RecyclerView.ViewHolder {
        private FrameLayout flVideo;
        private ImageView ivCover;
        private VideoLoadingProgressbar pbLoading;
        private TextView btnEvent;
        private ImageView ivComment;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            flVideo = itemView.findViewById(R.id.flVideo);
            ivCover = itemView.findViewById(R.id.ivCover);
            pbLoading = itemView.findViewById(R.id.pbLoading);
            btnEvent = itemView.findViewById(R.id.tv_main);
            ivComment = itemView.findViewById(R.id.iv_comment);
        }
    }
}
