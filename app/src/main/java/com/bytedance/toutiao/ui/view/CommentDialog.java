package com.bytedance.toutiao.ui.view;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
    private View view;
    private EditText etComment;
    private LinearLayout layoutComment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_comment, container);
        recyclerView = view.findViewById(R.id.rv_comment);
        tvTitle = view.findViewById(R.id.tv_tile);
        etComment = view.findViewById(R.id.et_comment);
        layoutComment = view.findViewById(R.id.layout_comment);
        init();
//        etComment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        Rect outRect = new Rect();
//        getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) recyclerView.getLayoutParams();
//        params.height = outRect.bottom - outRect.top;
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
