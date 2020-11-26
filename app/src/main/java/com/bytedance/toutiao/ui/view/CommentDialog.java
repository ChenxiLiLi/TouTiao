package com.bytedance.toutiao.ui.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.bytedance.toutiao.R;
import com.bytedance.toutiao.bean.CommentModel;
import com.bytedance.toutiao.bean.MessageChatModel;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.ui.video.adapter.CommentAdapter;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;

import java.util.ArrayList;
import java.util.List;


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
    private Button btnPublish;
    private MessageCommentViewModel mViewModel;
    private List<MessageCommentModel> messageCommentModels = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_comment, container);
        mViewModel = ViewModelProviders.of(getActivity()).get(MessageCommentViewModel.class);

        recyclerView = view.findViewById(R.id.rv_comment);
        tvTitle = view.findViewById(R.id.tv_comment_title);
        etComment = view.findViewById(R.id.et_comment);
        btnPublish = view.findViewById(R.id.btn_publish);
        layoutComment = view.findViewById(R.id.layout_comment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        commentAdapter = new CommentAdapter(getContext(), messageCommentModels);
        recyclerView.setAdapter(commentAdapter);
        mViewModel.getMsgComment().observe(getActivity(), new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                messageCommentModels.addAll(listResource.data);
                tvTitle.setText(messageCommentModels.size() + "条评论");
                commentAdapter.notifyDataSetChanged();
            }
        });


        btnPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(etComment.getText())){
                    MessageCommentModel messageCommentModel = new MessageCommentModel();
                    SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
                    messageCommentModel.setMsgCommentUserName(sp.getString("username", null));
                    messageCommentModel.setMsgCommentContent(etComment.getText().toString());
                    messageCommentModel.setLoveNum("0");
                    etComment.setText("");
                    messageCommentModels.add(messageCommentModel);
                    tvTitle.setText(messageCommentModels.size() + "条评论");
                    commentAdapter.notifyDataSetChanged();
                }else{
                    ToastUtils.showToast("请输入评论");
                }

            }
        });

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

    @Override
    protected int getHeight() {
        return getResources().getDisplayMetrics().heightPixels - 400;
    }
}
