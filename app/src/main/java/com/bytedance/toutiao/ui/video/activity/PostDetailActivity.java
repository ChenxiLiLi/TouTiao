package com.bytedance.toutiao.ui.video.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.MessageCommentModel;
import com.bytedance.toutiao.bean.ParcablePostData;
import com.bytedance.toutiao.bean.PostDetailModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.databinding.ActivityPostDetailBinding;
import com.bytedance.toutiao.ui.video.adapter.PostDetailAdapter;
import com.bytedance.toutiao.utils.ToastUtils;
import com.bytedance.toutiao.viewmodel.MessageCommentViewModel;
import com.bytedance.toutiao.viewmodel.VideoViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostDetailActivity extends BaseActivity<MessageCommentViewModel, ActivityPostDetailBinding> {

    private RecyclerView recyclerView;
    private PostDetailAdapter postDetailAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<MessageCommentModel> messageCommentModels = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_post_detail;
    }

    @Override
    protected void processLogic() {
        //接收参数
        final Bundle bundle = getIntent().getExtras();
        ParcablePostData parcablePostData = bundle.getParcelable("postDetail");
        binding.tvAuthor.setText("作者：@" + parcablePostData.getAuthorName());
        binding.tvContent.setText(parcablePostData.getContent());
        mViewModel = ViewModelProviders.of(this).get(MessageCommentViewModel.class);
        recyclerView = findViewById(R.id.rv_post_detail);
        postDetailAdapter = new PostDetailAdapter(this, messageCommentModels);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(postDetailAdapter);
        mViewModel.getMsgComment().observe(this, new Observer<Resource<List<MessageCommentModel>>>() {
            @Override
            public void onChanged(Resource<List<MessageCommentModel>> listResource) {
                messageCommentModels.addAll(listResource.data);
                binding.tvAllComment.setText("全部评论（" + messageCommentModels.size() + "）");
                postDetailAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void setListener() {
        binding.btnPubish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(binding.etComment.getText())){
                    MessageCommentModel messageCommentModel = new MessageCommentModel();
                    SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
                    messageCommentModel.setMsgCommentUserName(sp.getString("username", null));
                    messageCommentModel.setMsgCommentContent(binding.etComment.getText().toString());
                    messageCommentModel.setLoveNum("0");
                    binding.etComment.setText("");
                    messageCommentModels.add(messageCommentModel);
                    binding.tvAllComment.setText("全部评论（" + messageCommentModels.size() + "）");
                    postDetailAdapter.notifyDataSetChanged();
                }else{
                    ToastUtils.showToast("请输入评论");
                }
            }
        });

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
