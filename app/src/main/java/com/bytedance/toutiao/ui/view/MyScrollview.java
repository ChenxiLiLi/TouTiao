package com.bytedance.toutiao.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;


public class MyScrollview extends ScrollView {

    private boolean isScrolledToTop;
    private boolean isScrolledToBottom;
    private IScrollChangedListener mScrollChangedListener;


    public MyScrollview(Context context) {
        super(context);
    }

    public MyScrollview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyScrollview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollViewListener(IScrollChangedListener scrollViewListener) {
        this.mScrollChangedListener = scrollViewListener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        // We take the last son in the scrollview
        View view = getChildAt(0);
        if (view == null)
            return;
        int diff = (view.getBottom() - (getHeight() + getScrollY()));
//        System.out.println("diff= " + diff
//                + ",view.getBottom()=" + view.getBottom()
//                + ",this.getHeight()=" + getHeight()
//                + ",this.getScrollY()=" + getScrollY());
        // if diff is zero, then the bottom has been reached
        isScrolledToBottom = false;
        isScrolledToTop = false;
        if (diff == 0) {
            isScrolledToBottom = true;
            if (mScrollChangedListener != null)
                mScrollChangedListener.onScrolledToBottom();
        } else if (getScrollY() == 0) {
            isScrolledToTop = true;
            if (mScrollChangedListener != null)
                mScrollChangedListener.onScrolledToTop();
        }
    }

    public boolean isTopEnd() {
        return isScrolledToTop;
    }

    public boolean isBottomEnd() {
        return isScrolledToBottom;
    }

    /**
     * 定义监听接口
     */
    public interface IScrollChangedListener {
        void onScrolledToBottom();

        void onScrolledToTop();
    }

}