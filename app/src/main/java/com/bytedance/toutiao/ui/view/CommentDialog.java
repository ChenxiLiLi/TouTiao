package com.bytedance.toutiao.ui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.CommentModel;
import com.bytedance.toutiao.ui.video.adapter.CommentAdapter;

import java.util.ArrayList;


/**
 *
 * description 评论弹框
 */
public class CommentDialog extends BaseBottomSheetDialog {
    RecyclerView recyclerView;
    TextView tvTitle;
    private CommentAdapter commentAdapter;
    private ArrayList<CommentModel> datas = new ArrayList<>();
    private View view;
    private int[] likeArray = new int[]{4919, 334, 121, 423, 221, 23};
    private String[] commentArray = new String[]{"我就说左脚踩右脚可以上天你们还不信！", "全是评论点赞，没人关注吗", "哈哈哈哈", "像谁，没看出来", "你这西安话真好听"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_comment, container);
        recyclerView = view.findViewById(R.id.rv_comment);
        tvTitle = view.findViewById(R.id.tv_tile);
        init();

        return view;
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        commentAdapter = new CommentAdapter(getContext());
        recyclerView.setAdapter(commentAdapter);

        loadData();
    }

    private void loadData() {

    }

    @Override
    protected int getHeight() {
        return getResources().getDisplayMetrics().heightPixels - 600;
    }
}
