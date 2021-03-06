package com.bytedance.toutiao.ui.video.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseFragment;
import com.bytedance.toutiao.bean.DataCreate;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.VideoModel;
import com.bytedance.toutiao.databinding.FragmentRecommentVideoBinding;
import com.bytedance.toutiao.ui.video.adapter.VideoListAdapter;
import com.bytedance.toutiao.viewmodel.VideoViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentRecommentVideo extends BaseFragment<VideoViewModel, FragmentRecommentVideoBinding> {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private VideoListAdapter videoListAdapter;
    private List<VideoModel> videoModels = new ArrayList<>();

    public FragmentRecommentVideo() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_recomment_video;
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(getActivity()).get(VideoViewModel.class);
        initData();
        binding.setViewModel(mViewModel);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        binding.rvVideo.setLayoutManager(gridLayoutManager);
        videoListAdapter = new VideoListAdapter(getActivity(),videoModels);
        binding.rvVideo.setAdapter(videoListAdapter);
    }

    @Override
    protected void setListener() {
        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                replaceRecommentVideo();
                binding.swipeRefresh.setRefreshing(false);
            }
        });


        binding.rvVideo.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                //当前RecyclerView显示出来的最后一个的item的position
                int lastPosition = -1;

                //当前状态为停止滑动状态SCROLL_STATE_IDLE时
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if(layoutManager instanceof GridLayoutManager){
                        //通过LayoutManager找到当前显示的最后的item的position
                        lastPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    //时判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                    //如果相等则说明已经滑动到最后了
                    if(lastPosition == recyclerView.getLayoutManager().getItemCount()-1){
                        Toast.makeText(getActivity(), "加载更多", Toast.LENGTH_SHORT).show();
                        addRecommentVideoToList();
                    }

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            }

        });


    }

    @Override
    public void onClick(View view) {

    }

    private void initData(){
        videoModels.addAll(DataCreate.getVideoList());
        addRecommentVideoToList();

    }

    private void addRecommentVideoToList(){
        mViewModel.getRecommentVideo().observe(getActivity(), new Observer<Resource<List<VideoModel>>>() {
            @Override
            public void onChanged(Resource<List<VideoModel>> listResource) {
                videoModels.addAll(listResource.data);
                videoListAdapter.notifyDataSetChanged();
            }
        });
    }

    private void replaceRecommentVideo(){
        mViewModel.getRecommentVideo().observe(getActivity(), new Observer<Resource<List<VideoModel>>>() {
            @Override
            public void onChanged(Resource<List<VideoModel>> listResource) {
                videoModels.clear();
                videoModels.addAll(listResource.data);
                videoListAdapter.notifyDataSetChanged();
                binding.rvVideo.setAdapter(videoListAdapter);

            }
        });
    }

}
