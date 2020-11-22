package com.bytedance.toutiao.ui.video.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.CommonAdapter;
import com.bytedance.toutiao.bean.VideoModel;
import com.bytedance.toutiao.databinding.ItemVideoDetailBinding;
import com.bytedance.toutiao.ui.video.activity.TopicSquareActivity;
import com.bytedance.toutiao.ui.view.CommentDialog;
import com.bytedance.toutiao.ui.view.VideoLoadingProgressbar;
import com.bytedance.toutiao.ui.view.VideoPlayer;
import com.bytedance.toutiao.ui.view.media.VideoPlayAdapter;
import com.bytedance.toutiao.utils.ToastUtils;

import java.io.IOException;
import java.util.List;

public class VideoDetailAdapter extends VideoPlayAdapter<VideoDetailAdapter.ViewHolder> {

    private Context mContext;
    private int mCurrentPosition;
    private ViewHolder mCurrentHolder;
    private List<VideoModel> videoModels;
    public ItemVideoDetailBinding binding;
    private Resources resources;
    private VideoPlayer videoPlayer;
    private TextureView textureView;
    private int resid ;
    private Listener listener;
    private boolean isLove = false;

    public VideoDetailAdapter(Context mContext, Resources resources, List<VideoModel> videoModels) {
        this.mContext = mContext;
        this.resources = resources;
        this.videoModels = videoModels;
        videoPlayer = new VideoPlayer();
        textureView = new TextureView(mContext);
        videoPlayer.setTextureView(textureView);
    }

    public interface Listener extends View.OnClickListener{
        @Override
        void onClick(View view);

        void refresh(VideoModel videoModel);

    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_video_detail, parent, false);
        VideoDetailAdapter.ViewHolder myHolder = new VideoDetailAdapter.ViewHolder(binding.getRoot());
        myHolder.setBinding(binding);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        binding = (ItemVideoDetailBinding) holder.getBinding();
        VideoModel videoModel = videoModels.get(position);

        binding.tvMain.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        switch (videoModel.getVideoId()){
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
        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE);
        Glide.with(mContext).load(resid).apply(options).into(binding.ivCover);
        binding.tvMain.setText(videoModel.getEventName());
        binding.tvTile.setText(videoModel.getTitle());
        binding.tvAuthorName.setText(videoModel.getAuthorName());
        binding.tvContent.setText(videoModel.getContent());
        binding.tvCommentNum.setText(videoModel.getCommentNum());
        binding.tvLoveNum.setText(videoModel.getLoveNum());
        binding.ivComment.setOnClickListener(listener);
        binding.tvComment.setOnClickListener(listener);
        binding.ibBack.setOnClickListener(listener);
        binding.flVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoPlayer.pause();
            }
        });
        binding.btnFocus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnFocus.setText("已关注");
                ToastUtils.showToast("关注成功");
            }
        });

        binding.tvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, TopicSquareActivity.class);
                mContext.startActivity(intent);
            }
        });

        binding.ivLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLove){
                    binding.ivLove.setSelected(false);
                    isLove = false;
                }
                else{
                    binding.ivLove.setSelected(true);
                    isLove = true;
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return videoModels.size();
    }

    @Override
    public void onPageSelected(int itemPosition, View itemView) {
        listener.refresh(videoModels.get(itemPosition));
        mCurrentPosition = itemPosition;
        mCurrentHolder = new ViewHolder(itemView);
        playVideo();
    }

    private void playVideo() {
        videoPlayer.reset();
        binding.pbLoading.setVisibility(View.VISIBLE);
        videoPlayer.setOnStateChangeListener(new VideoPlayer.OnStateChangeListener() {
            @Override
            public void onReset() {
                binding.ivCover.setVisibility(View.VISIBLE);
                binding.pbLoading.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onRenderingStart() {
                binding.ivCover.setVisibility(View.GONE);
                binding.pbLoading.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onProgressUpdate(float per) {
            }

            @Override
            public void onPause() {
                binding.pbLoading.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onStop() {
                binding.ivCover.setVisibility(View.VISIBLE);
                binding.pbLoading.setVisibility(View.INVISIBLE);
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
            afd = resources.getAssets().openFd("local_video" + videoModels.get(mCurrentPosition).getVideoId() +".mp4");
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
        ViewDataBinding binding;
        public ViewDataBinding getBinding(){
            return binding;
        }

        public void setBinding(ViewDataBinding binding){
            this.binding = binding;
        }


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            flVideo = itemView.findViewById(R.id.flVideo);
        }
    }
}
