package com.bytedance.toutiao.ui.video.activity;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.ImageModel;
import com.bytedance.toutiao.databinding.ActivityPostDetailBinding;
import com.bytedance.toutiao.databinding.ActivityPostPublishBinding;
import com.bytedance.toutiao.ui.video.adapter.PostPublishAdapter;
import com.bytedance.toutiao.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class PostPublishActivity extends BaseActivity<NormalViewModel, ActivityPostPublishBinding>{
    private List<ImageModel> list = new ArrayList<>();
    private PostPublishAdapter postPublishAdapter;
    private ImageModel addPic;
    @Override
    protected int getContentViewId() {
        return R.layout.activity_post_publish;
    }

    @Override
    protected void processLogic() {

        addPic = new ImageModel();
        addPic.setRsId(R.drawable.add_pic);
        list.add(addPic);
        postPublishAdapter = new PostPublishAdapter(this, list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        binding.rvImage.setLayoutManager(gridLayoutManager);
        binding.rvImage.setAdapter(postPublishAdapter);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //未授权，申请授权(从相册选择图片需要读取存储卡的权限)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, RC_CHOOSE_PHOTO);
        } else {
            //已授权，获取照片
        }
        postPublishAdapter.setListener(new PostPublishAdapter.Listener() {
            @Override
            public void onClick() {
                choosePhoto();
            }
        });
    }
    public static final int RC_CHOOSE_PHOTO = 2;

    private void choosePhoto() {
        Intent intentToPickPic = new Intent(Intent.ACTION_PICK, null);
        intentToPickPic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intentToPickPic, RC_CHOOSE_PHOTO);
    }
    @Override
    protected void setListener() {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RC_CHOOSE_PHOTO:
                Uri uri = data.getData();
                String filePath = FileUtils.getFilePathByUri(this, uri);

                if (!TextUtils.isEmpty(filePath)) {
                    //将照片显示在 ivImage上
                    ImageModel imageModel = new ImageModel();
                    imageModel.setFilePath(filePath);
                    if(list.size() == 1) {
                        list.clear();
                        list.add(imageModel);
                        list.add(addPic);
                    }else if(list.size() == 9){
                        list.remove(list.size() - 1);
                        list.add(imageModel);
                    }
                    else {
                        list.remove(list.size() - 1);
                        list.add(imageModel);
                        list.add(addPic);
                    }
                    postPublishAdapter.notifyDataSetChanged();

//                    Glide.with(this).load(filePath).apply(requestOptions1).into(ivImage);
                }
                break;
        }
    }
}
