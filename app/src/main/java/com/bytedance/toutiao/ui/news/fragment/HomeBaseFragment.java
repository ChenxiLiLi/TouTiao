package com.bytedance.toutiao.ui.news.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.ui.news.adapter.HomeListAdapter;

public class HomeBaseFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private String name;

    public HomeBaseFragment(String name) {
        this.name = name;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle bundle){
        View view = null;
        if ("follow".equals(name)) {
            view = layoutInflater.inflate(R.layout.fragment_home_follow, container, false);
            recyclerView = view.findViewById(R.id.home_follow);

        }
        if ("news".equals(name)) {
            view = layoutInflater.inflate(R.layout.fragment_home_news, container, false);
            recyclerView = view.findViewById(R.id.home_news);
        }
        if ("sameCity".equals(name)) {
            view = layoutInflater.inflate(R.layout.fragment_home_samecity, container, false);
            recyclerView = view.findViewById(R.id.home_samecity);
        }


        linearLayoutManager = new LinearLayoutManager(getActivity());

        HomeListAdapter homeListAdapter = new HomeListAdapter(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeListAdapter);
        return view;
    }
}
