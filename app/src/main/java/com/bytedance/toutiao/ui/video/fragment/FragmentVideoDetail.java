package com.bytedance.toutiao.ui.video.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.VideoModel;
import com.bytedance.toutiao.databinding.FragmentVideoDetailBinding;
import com.bytedance.toutiao.ui.video.adapter.VideoDetailAdapter;
import com.bytedance.toutiao.ui.video.adapter.VideoFragmentAdapter;
import com.bytedance.toutiao.ui.view.CommentDialog;
import com.bytedance.toutiao.ui.view.media.VideoPlayRecyclerView;
import com.bytedance.toutiao.viewmodel.VideoViewModel;


import java.util.ArrayList;
import java.util.List;

public class FragmentVideoDetail extends BaseFragment<VideoViewModel, FragmentVideoDetailBinding> {

    private VideoDetailAdapter adapter;
    private String videoID;
    private List<VideoModel> videoModels = new ArrayList<>();

    public FragmentVideoDetail(String videoID) {
        this.videoID = "1";
    }


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_video_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initData();

        adapter = new VideoDetailAdapter(getActivity(), getResources(), videoModels);
        adapter.setListener(new VideoDetailAdapter.Listener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.iv_comment:
                        CommentDialog commentDialog = new CommentDialog();
                        commentDialog.show(getChildFragmentManager(), "");
                        break;
                }
            }

            @Override
            public void refresh(String eventId, String title) {
                FragmentVideoEvent fragmentVideoEvent = (FragmentVideoEvent) getActivity()
                        .getSupportFragmentManager()
                        .findFragmentByTag("android:switcher:"+R.id.video_detail_view_pager+":"+0);
                fragmentVideoEvent.setData("1", "南昌杀妻抛尸案");
            }
        });
        binding.rvVideoDetail.setAdapter(adapter);
    }

    @Override
    protected void setListener() {
        binding.rvVideoDetail.setOnScrollListener(new VideoPlayRecyclerView.OnScrollListener() {
            @Override
            public void addMoreVideo() {
                VideoModel videoModel1 = new VideoModel();
                videoModel1.setVideoId("1");
                videoModel1.setAuthorName("@四川观察");
                videoModel1.setImgId(R.mipmap.local_pic1);
                videoModel1.setVideoUrl("local_video1.mp4");
                videoModel1.setContent("四川富顺灭门案告破！");
                videoModel1.setCommentNum("233");
                videoModel1.setLoveNum("1.7w");

                videoModels.add(videoModel1);

                adapter.notifyDataSetChanged();
            }

            @Override
            public void replaceVideo() {
                VideoModel videoModel1 = new VideoModel();
                videoModel1.setVideoId("1");
                videoModel1.setAuthorName("@四川观察");
                videoModel1.setImgId(R.mipmap.local_pic1);
                videoModel1.setVideoUrl("local_video1.mp4");
                videoModel1.setContent("四川富顺灭门案告破！");
                videoModel1.setCommentNum("233");
                videoModel1.setLoveNum("1.7w");

                VideoModel videoModel2 = new VideoModel();
                videoModel2.setVideoId("2");
                videoModel2.setAuthorName("@北京警方");
                videoModel2.setImgId(R.mipmap.local_pic2);
                videoModel2.setVideoUrl("local_video2.mp4");
                videoModel2.setContent("玛莎拉蒂撞人案有了新进展， 被害人坚持以命偿命 ！");
                videoModel2.setCommentNum("2333");
                videoModel2.setLoveNum("7.7w");
                videoModels.clear();
                videoModels.add(videoModel1);
                videoModels.add(videoModel2);
                adapter.notifyDataSetChanged();
            }
        });


    }

    private void initData(){
        {
            VideoModel videoModel1 = new VideoModel();
            VideoModel videoModel2 = new VideoModel();
            VideoModel videoModel3 = new VideoModel();
            VideoModel videoModel4 = new VideoModel();



            videoModel1.setVideoId("1");
            videoModel1.setAuthorName("@四川观察");
            videoModel1.setImgId(R.mipmap.local_pic1);
            videoModel1.setVideoUrl("local_video1.mp4");
            videoModel1.setContent("四川富顺灭门案告破！");
            videoModel1.setCommentNum("233");
            videoModel1.setLoveNum("1.7w");

            videoModel2.setVideoId("2");
            videoModel2.setAuthorName("@北京警方");
            videoModel2.setImgId(R.mipmap.local_pic2);
            videoModel2.setVideoUrl("local_video2.mp4");
            videoModel2.setContent("玛莎拉蒂撞人案有了新进展， 被害人坚持以命偿命 ！");
            videoModel2.setCommentNum("2333");
            videoModel2.setLoveNum("7.7w");

            videoModel3.setVideoId("3");
            videoModel3.setAuthorName("@新疆媒体");
            videoModel3.setImgId(R.mipmap.local_pic3);
            videoModel3.setVideoUrl("local_video3.mp4");
            videoModel3.setContent("南昌杀妻抛尸案判决 ！ 凶手被判死刑！");
            videoModel3.setCommentNum("233");
            videoModel3.setLoveNum("1.7w");

            videoModel4.setVideoId("1");
            videoModel4.setAuthorName("@四川观察");
            videoModel4.setImgId(R.mipmap.local_pic1);
            videoModel4.setVideoUrl("local_video1.mp4");
            videoModel4.setContent("四川富顺灭门案告破！");
            videoModel4.setCommentNum("233");
            videoModel4.setLoveNum("1.7w");

            switch (videoID){
                case "3":videoModels.add(videoModel3);
                    break;
                case "2":videoModels.add(videoModel2);
                    break;
                case "1":videoModels.add(videoModel1);
                break;
            }

            videoModels.add(videoModel1);
            videoModels.add(videoModel2);
            videoModels.add(videoModel3);
            videoModels.add(videoModel4);
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPause() {
        super.onPause();
        adapter.pause();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter.release();
    }


}
