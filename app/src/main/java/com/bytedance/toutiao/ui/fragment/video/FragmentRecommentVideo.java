package com.bytedance.toutiao.ui.fragment.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.ui.adapter.video.VideoListAdapter;

public class FragmentRecommentVideo extends Fragment {
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;

    public FragmentRecommentVideo() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle bundle){
        View view = layoutInflater.inflate(R.layout.fragment_recomment_video, container, false);
        recyclerView = view.findViewById(R.id.rv_video);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        VideoListAdapter videoListAdapter = new VideoListAdapter(getActivity());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(videoListAdapter);
        return view;
    }
}
