package com.bytedance.toutiao.ui.video.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.VideoModel;
import com.bytedance.toutiao.ui.video.adapter.VideoListAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentCityVideo extends BaseFragment {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private VideoListAdapter videoListAdapter;
    private List<VideoModel> videoModels = new ArrayList<>();

    public FragmentCityVideo() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_city_video;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initData();
        recyclerView = mContentView.findViewById(R.id.rv_video);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        videoListAdapter = new VideoListAdapter(getActivity(),videoModels);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(videoListAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View view) {

    }
    private void initData(){
        VideoModel videoModel1 = new VideoModel();
        VideoModel videoModel2 = new VideoModel();
        VideoModel videoModel3 = new VideoModel();
        VideoModel videoModel4 = new VideoModel();

        videoModel1.setVideoID("1");
        videoModel1.setAuthorName("@四川观察");
        videoModel1.setImgId(R.mipmap.local_pic1);
        videoModel1.setVideoUrl("local_video1.mp4");
        videoModel1.setContent("四川富顺灭门案告破！");
        videoModel1.setCommentNum("233");
        videoModel1.setLoveNum("1.7w");

        videoModel2.setVideoID("2");
        videoModel2.setAuthorName("@北京警方");
        videoModel2.setImgId(R.mipmap.local_pic2);
        videoModel2.setVideoUrl("local_video2.mp4");
        videoModel2.setContent("玛莎拉蒂撞人案有了新进展， 被害人坚持以命偿命 ！");
        videoModel2.setCommentNum("2333");
        videoModel2.setLoveNum("7.7w");

        videoModel3.setVideoID("3");
        videoModel3.setAuthorName("@新疆媒体");
        videoModel3.setImgId(R.mipmap.local_pic3);
        videoModel3.setVideoUrl("local_video3.mp4");
        videoModel3.setContent("南昌杀妻抛尸案判决 ！ 凶手被判死刑！");
        videoModel3.setCommentNum("233");
        videoModel3.setLoveNum("1.7w");

        videoModel4.setVideoID("1");
        videoModel4.setAuthorName("@四川观察");
        videoModel4.setImgId(R.mipmap.local_pic1);
        videoModel4.setVideoUrl("local_video1.mp4");
        videoModel4.setContent("四川富顺灭门案告破！");
        videoModel4.setCommentNum("233");
        videoModel4.setLoveNum("1.7w");

        videoModels.add(videoModel2);
        videoModels.add(videoModel4);
        videoModels.add(videoModel1);
        videoModels.add(videoModel3);
    }
}
