package com.bytedance.toutiao.ui.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bytedance.toutiao.R;

public class PublishDialog extends BaseBottomSheetDialog {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_publish, container);

        return view;
    }



    @Override
    protected int getHeight() {
        return getResources().getDisplayMetrics().heightPixels - 1800;
    }
}
