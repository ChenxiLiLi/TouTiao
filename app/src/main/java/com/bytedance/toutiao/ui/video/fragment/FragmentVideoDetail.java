package com.bytedance.toutiao.ui.video.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.DataCreate;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.VideoModel;
import com.bytedance.toutiao.databinding.FragmentVideoDetailBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.ui.video.adapter.VideoDetailAdapter;
import com.bytedance.toutiao.ui.video.adapter.VideoFragmentAdapter;
import com.bytedance.toutiao.ui.view.CommentDialog;
import com.bytedance.toutiao.ui.view.ToLoginfragment;
import com.bytedance.toutiao.ui.view.media.VideoPlayRecyclerView;
import com.bytedance.toutiao.viewmodel.VideoViewModel;


import java.util.ArrayList;
import java.util.List;

public class FragmentVideoDetail extends BaseFragment<VideoViewModel, FragmentVideoDetailBinding> {

    private VideoDetailAdapter adapter;
    private String videoID;
    private List<VideoModel> videoModels = new ArrayList<>();

    public FragmentVideoDetail(String videoID) {
        this.videoID = videoID;
    }


    @Override
    protected int getContentViewId() {
        return R.layout.fragment_video_detail;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        initData();
        mViewModel = ViewModelProviders.of(getActivity()).get(VideoViewModel.class);
        adapter = new VideoDetailAdapter(getActivity(), getResources(), videoModels);
        adapter.setListener(new VideoDetailAdapter.Listener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.ib_back:
                        Intent toMainActivity = new Intent(getContext(), MainActivity.class);
                        getActivity().startActivity(toMainActivity);
                        break;
                    case R.id.tv_comment_num:
                    case R.id.iv_comment:
                        CommentDialog commentDialog = new CommentDialog();
                        commentDialog.show(getChildFragmentManager(), "");
                        break;
                }
            }

            @Override
            public void refresh(VideoModel videoModel) {
                FragmentVideoEvent fragmentVideoEvent = (FragmentVideoEvent) getActivity()
                        .getSupportFragmentManager()
                        .findFragmentByTag("android:switcher:"+R.id.video_detail_view_pager+":"+0);
                fragmentVideoEvent.setData(videoModel.getVideoId(), videoModel.getEventName());

                FragmentVideoNode fragmentVideoNode= (FragmentVideoNode) getActivity()
                        .getSupportFragmentManager()
                        .findFragmentByTag("android:switcher:"+R.id.video_detail_view_pager+":"+2);
                fragmentVideoNode.setData(videoModel.getVideoId(), videoModel.getTitle());
            }

            @Override
            public boolean showToLoginFragment() {
                    SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                    if(null == (sp.getString("username", null))){
                        ToLoginfragment toLoginfragment = new ToLoginfragment();
                        toLoginfragment.show(getChildFragmentManager(), "");
                        return false;
                    }else return true;
            }
        });
        binding.rvVideoDetail.setAdapter(adapter);
    }

    @Override
    protected void setListener() {
        binding.rvVideoDetail.setOnScrollListener(new VideoPlayRecyclerView.OnScrollListener() {
            @Override
            public void addMoreVideo() {
                addMoreVideo();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void replaceVideo() {
                replaceRecommentVideo();
                adapter.notifyDataSetChanged();
            }
        });


    }

    private void initData(){
        videoModels.add(DataCreate.getVideoById(videoID));
        videoModels.addAll(DataCreate.getVideoList());
    }

    private void addRecommentVideoToList(){
        mViewModel.getRecommentVideo().observe(getActivity(), new Observer<Resource<List<VideoModel>>>() {
            @Override
            public void onChanged(Resource<List<VideoModel>> listResource) {
                if(listResource.state == 1)
                    videoModels.addAll(listResource.data);
            }
        });
    }

    private void replaceRecommentVideo(){
        mViewModel.getRecommentVideo().observe(getActivity(), new Observer<Resource<List<VideoModel>>>() {
            @Override
            public void onChanged(Resource<List<VideoModel>> listResource) {
                videoModels.clear();
                videoModels.addAll(listResource.data);

            }
        });
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
