package com.bytedance.toutiao.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.TestViewModel;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.databinding.ActivityMainBinding;

import com.bytedance.toutiao.ui.search.SearchActivity;
import com.bytedance.toutiao.ui.user.fragment.FragmentUser;
//import com.bytedance.toutiao.ui.news.FragmentHome;
import com.bytedance.toutiao.ui.message.Fragment.FragmentMessage;
import com.bytedance.toutiao.ui.news.fragment.FragmentNews;
import com.bytedance.toutiao.ui.message.Fragment.FragmentMessage;
import com.bytedance.toutiao.ui.video.fragment.FragmentVideo;
import com.bytedance.toutiao.ui.view.PublishDialog;
import com.bytedance.toutiao.ui.view.ToLoginfragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<TestViewModel, ActivityMainBinding> {
    private static final int FRAGMENT_ONE = 0;
    private static final int FRAGMENT_TWO = 1;
    private static final int FRAGMENT_THREE = 2;
    private static final int FRAGMENT_FOUR = 3;
    private int index;
    private int currentTabIndex = 0;
    FragmentNews fragment_one;
    FragmentVideo fragment_two;
    FragmentMessage fragment_three;
    FragmentUser fragment_four;
    private RelativeLayout[] mTabs;
    private FragmentManager manager;
    private ArrayList<Fragment> list_fragment = new ArrayList<Fragment>();

    @Override
    protected int getContentViewId(){
        return R.layout.activity_main;
    }

    @Override
    protected void processLogic() {
        initFragment();
    }

    @Override
    protected void setListener(){

        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.relative_tab_home:
                        switchFragment(R.id.relative_tab_home);
                        break;
                    case R.id.relative_tab_video:
                        switchFragment(R.id.relative_tab_video);
                        break;
                    case R.id.relative_tab_message:
                        switchFragment(R.id.relative_tab_message);
                        break;
                    case R.id.relative_tab_user:
                        switchFragment(R.id.relative_tab_user);
                        break;
                    case R.id.icon_message:
                        Toast.makeText(MainActivity.this, "进入搜索界面", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }




    private void initFragment() {
        manager = getSupportFragmentManager();
        mTabs = new RelativeLayout[4];
        mTabs[0] = binding.relativeTabHome;
        mTabs[1] = binding.relativeTabVideo;
        mTabs[2] = binding.relativeTabMessage;
        mTabs[3] = binding.relativeTabUser;
        fragment_one = FragmentNews.newFragment(1);
        fragment_two = FragmentVideo.newFragment(2);
        fragment_three = FragmentMessage.newFragment(3);
        fragment_four = FragmentUser.newFragment(4);
        list_fragment.add(fragment_one);
        list_fragment.add(fragment_two);
        list_fragment.add(fragment_three);
        list_fragment.add(fragment_four);
        switchFragment(R.id.relative_tab_home);
    }


    public void switchFragment(int id) {
        FragmentTransaction ft = manager.beginTransaction();
        //fragment切换带动画
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);

        RelativeLayout relativeLayout =  findViewById(id);
        String tag = (String) relativeLayout.getTag();
        Fragment f = manager.findFragmentByTag(tag);
        if (f == null) {
            int num = Integer.parseInt(tag);
            ft.add(R.id.framLayout, list_fragment.get(num), tag);

        }

        for (int i = 0; i < list_fragment.size(); i++) {
            Fragment fragment = list_fragment.get(i);
            if (fragment.getTag() != null) {
                if (fragment.getTag().equals(tag)) {
                    ft.show(fragment);
                } else {
                    ft.hide(fragment);
                }
            }
        }
        ft.commitAllowingStateLoss();
        switch (id) {
            case R.id.relative_tab_home://首页
                index = FRAGMENT_ONE;
                break;
            case R.id.relative_tab_video:
                index = FRAGMENT_TWO;
                break;
            case R.id.relative_tab_message:
                index = FRAGMENT_THREE;
                break;
            case R.id.relative_tab_user:
                index = FRAGMENT_FOUR;
                break;
        }
        mTabs[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }

}
