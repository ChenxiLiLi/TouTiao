package com.bytedance.toutiao.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.TestViewModel;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.bean.Resource;
import com.bytedance.toutiao.bean.User;
import com.bytedance.toutiao.bean.basebean.ResponseModel;
import com.bytedance.toutiao.databinding.ActivityMainBinding;

import com.bytedance.toutiao.retrofit.RetrofitApiService;
import com.bytedance.toutiao.retrofit.RetrofitManager;
import com.bytedance.toutiao.ui.fragment.FragmentFour;
import com.bytedance.toutiao.ui.fragment.FragmentOne;
import com.bytedance.toutiao.ui.fragment.FragmentThree;
import com.bytedance.toutiao.ui.fragment.FragmentTwo;
import com.bytedance.toutiao.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;

public class MainActivity extends BaseActivity<TestViewModel, ActivityMainBinding> {
    private static final int FRAGMENT_ONE = 0;
    private static final int FRAGMENT_TWO = 1;
    private static final int FRAGMENT_THREE = 2;
    private static final int FRAGMENT_FOUR = 3;
    private int index;
    private int currentTabIndex = 0;
    FragmentOne fragment_one;
    FragmentTwo fragment_two;
    FragmentThree fragment_three;
    FragmentFour fragment_four;
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
                    case R.id.framLayout:
                        Toast.makeText(MainActivity.this, " clicked ", Toast.LENGTH_LONG).show();
                    case R.id.relative_tab_1:
                        switchFragment(R.id.relative_tab_1);
                        break;
                    case R.id.relative_tab_2:
                        Toast.makeText(MainActivity.this, " create ", Toast.LENGTH_LONG).show();
                        switchFragment(R.id.relative_tab_2);
                        break;
                    case R.id.relative_tab_3:
                        switchFragment(R.id.relative_tab_3);
                        break;
                    case R.id.relative_tab_4:
                        switchFragment(R.id.relative_tab_4);
                }
            }
        });
    }




    private void initFragment() {
        manager = getSupportFragmentManager();
        mTabs = new RelativeLayout[4];
        mTabs[0] = binding.relativeTab1;
        mTabs[1] = binding.relativeTab2;
        mTabs[2] = binding.relativeTab3;
        mTabs[3] = binding.relativeTab4;
        fragment_one = FragmentOne.newFragment(1);
        fragment_two = FragmentTwo.newFragment(2);
        fragment_three = FragmentThree.newFragment(3);
        fragment_four = FragmentFour.newFragment(4);
        list_fragment.add(fragment_one);
        list_fragment.add(fragment_two);
        list_fragment.add(fragment_three);
        list_fragment.add(fragment_four);
        switchFragment(R.id.relative_tab_1);
        Toast.makeText(MainActivity.this, " create ", Toast.LENGTH_LONG).show();
    }


    public void switchFragment(int id) {
        FragmentTransaction ft = manager.beginTransaction();
        //fragment切换带动画
//        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
//                android.R.anim.fade_in, android.R.anim.fade_out);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(id);
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
            case R.id.relative_tab_1://首页
                index = FRAGMENT_ONE;
                break;
            case R.id.relative_tab_2:
                index = FRAGMENT_TWO;
                break;
            case R.id.relative_tab_3:
                index = FRAGMENT_THREE;
                break;
            case R.id.relative_tab_4:
                index = FRAGMENT_FOUR;
                break;
        }
        mTabs[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        mTabs[index].setSelected(true);
        currentTabIndex = index;
    }

}
