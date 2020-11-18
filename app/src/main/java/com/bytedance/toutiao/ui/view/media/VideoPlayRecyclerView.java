package com.bytedance.toutiao.ui.view.media;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bytedance.toutiao.utils.ToastUtils;

/**
 * 视频播放上下滑动切换控件
 */
public class VideoPlayRecyclerView extends FrameLayout {
    private static final int COLOR_BG = Color.BLACK; // 背景色
    private static final float DRAG_RATE = 2.5f; // 下拉上拉的粘性（数值越大越难下拉）
    private static final int TEXT_COLOR = 0xff999999; // 提示文字颜色
    private static final float TEXT_SIZE = 12; // 提示文字大小
    private static final float TEXT_MARGIN = 150; // 提示文字和 RecyclerView 的间距

    private OnScrollListener onScrollListener;
    private RecyclerView recyclerView;
    private TextView tvTip;
    private PagerLayoutManager layoutManager;

    private float mDownX = -1;
    private float mDownY = -1;
    private float mLastY = -1;
    private boolean isPulling;

    public VideoPlayRecyclerView(Context context) {
        super(context);
        init();
    }

    public VideoPlayRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VideoPlayRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setBackgroundColor(COLOR_BG);
        // 提示TextView
        tvTip = new TextView(getContext());
        tvTip.setTextSize(TEXT_SIZE);
        tvTip.setTextColor(TEXT_COLOR);
        tvTip.setGravity(Gravity.CENTER_HORIZONTAL);
        addView(tvTip, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        // RecyclerView
        recyclerView = new NestRecyclerView(getContext());
        addView(recyclerView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        layoutManager = new PagerLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                //当前RecyclerView显示出来的最后一个的item的position
                int lastPosition = -1;

                //当前状态为停止滑动状态SCROLL_STATE_IDLE时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager instanceof LinearLayoutManager) {
                        //通过LayoutManager找到当前显示的最后的item的position
                        lastPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                    }
                    //时判断界面显示的最后item的position是否等于itemCount总数-1也就是最后一个item的position
                    //如果相等则说明已经滑动到最后了
                    if (lastPosition == recyclerView.getLayoutManager().getItemCount() - 1) {
                        onScrollListener.addMoreVideo();
                    }

                }
            }
        });

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setAdapter(VideoPlayAdapter adapter) {
        recyclerView.setAdapter(adapter);
        layoutManager.setOnPageChangeListener(adapter);
    }

    public void scrollToPosition(int position) {
        layoutManager.scrollToPositionWithOffset(position, 0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = ev.getRawX();
                mDownY = ev.getRawY();
                mLastY = ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaX = ev.getRawX() - mDownX;
                float deltaY = ev.getRawY() - mDownY;
                if (Math.abs(deltaY) > Math.abs(deltaX)) {
                    if (deltaY > 0 && !recyclerView.canScrollVertically(-1)) {
                        return true;
                    } else if (deltaY < 0 && !recyclerView.canScrollVertically(1)) {
                        return true;
                    }
                }
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    public interface OnScrollListener {
        void addMoreVideo();
        void replaceVideo();
    }

    public void setOnScrollListener(OnScrollListener onScrollListener){
        this.onScrollListener = onScrollListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mDownY == -1) {
            mDownY = ev.getRawY();
        }
        if (mLastY == -1) {
            mLastY = ev.getRawY();
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float deltaY = ev.getRawY() - mDownY;
                if (deltaY > 0 && !recyclerView.canScrollVertically(-1)) {
                    tvTip.setText("加载中");
                    onScrollListener.replaceVideo();
                    tvTip.setY(deltaY / DRAG_RATE - TEXT_MARGIN);
                    recyclerView.setY(deltaY / DRAG_RATE);
                    isPulling = true;
                }
//                else if (deltaY < 0 && !recyclerView.canScrollVertically(1)) {
//                    tvTip.setText("已经到底啦");
//                    onScrollListener.addMoreVideo();
//                    tvTip.setY(getHeight() + deltaY / DRAG_RATE + TEXT_MARGIN);
//                    recyclerView.setY(deltaY / DRAG_RATE);
//                    isPulling = true;
//                }
                mLastY = ev.getRawY();
                break;
            default:
                mDownY = -1;
                mLastY = -1;
                if (isPulling) {
                    TranslateAnimation animation;
                    // TextView 归位
                    if (recyclerView.getY() > 0) {
                        animation = new TranslateAnimation(0, 0, tvTip.getY(), -TEXT_MARGIN - tvTip.getHeight());
                    } else {
                        animation = new TranslateAnimation(0, 0, tvTip.getY(), getHeight() + TEXT_MARGIN);
                    }
                    animation.setDuration(300);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            tvTip.setY(-TEXT_MARGIN - tvTip.getHeight());
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    tvTip.setY(0);
                    tvTip.startAnimation(animation);
                    // RecyclerView 归位
                    TranslateAnimation animation1 = new TranslateAnimation(0, 0, recyclerView.getY(), 0);
                    animation1.setDuration(300);
                    animation1.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            recyclerView.setY(0);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                    recyclerView.setY(0);
                    recyclerView.startAnimation(animation1);

                    isPulling = false;
                }
                break;
        }
        return super.onTouchEvent(ev);
    }
}