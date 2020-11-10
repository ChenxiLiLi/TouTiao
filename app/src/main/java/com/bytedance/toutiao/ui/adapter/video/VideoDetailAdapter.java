package com.bytedance.toutiao.ui.adapter.video;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.toutiao.R;
import com.bytedance.toutiao.ui.activity.TopicSquareActivity;
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

    public VideoDetailAdapter(Context mContext, Resources resources, String videoID) {
        this.mContext = mContext;
        videoPlayer = new VideoPlayer();
        textureView = new TextureView(mContext);
        videoPlayer.setTextureView(textureView);
        this.resources = resources;
        this.videoID = videoID;
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
        Glide.with(mContext).load("R.mipmap.local_pic" + videoID + ".png").apply(options).into(holder.ivCover);
        holder.btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TopicSquareActivity.class);
                mContext.startActivity(intent);
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
            if (textureView.getParent() != null) {
                ((FrameLayout) textureView.getParent()).removeView(textureView);
            }
            mCurrentHolder.flVideo.addView(textureView);
        }
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


    class ViewHolder extends RecyclerView.ViewHolder {
        private FrameLayout flVideo;
        private ImageView ivCover;
        private VideoLoadingProgressbar pbLoading;
        private Button btnEvent;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            flVideo = itemView.findViewById(R.id.flVideo);
            ivCover = itemView.findViewById(R.id.ivCover);
            pbLoading = itemView.findViewById(R.id.pbLoading);
            btnEvent = itemView.findViewById(R.id.bt_main);
        }
    }
}
