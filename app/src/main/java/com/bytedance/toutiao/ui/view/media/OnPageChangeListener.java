package com.bytedance.toutiao.ui.view.media;

import android.view.View;

/**
 * page切换的监听器
 */
public interface OnPageChangeListener {
    void onPageSelected(int itemPosition, View itemView);
}