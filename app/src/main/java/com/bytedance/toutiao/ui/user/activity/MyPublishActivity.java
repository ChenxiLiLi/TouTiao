package com.bytedance.toutiao.ui.user.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivityMyPublishBinding;
import com.bytedance.toutiao.ui.MainActivity;
import com.bytedance.toutiao.ui.user.fragment.FragmentMyPublish;

import java.util.ArrayList;

public class MyPublishActivity extends BaseActivity<NormalViewModel, ActivityMyPublishBinding> {
    FragmentMyPublish fragment1;
    FragmentMyPublish fragment2;
    FragmentMyPublish fragment3;
    FragmentMyPublish fragment4;
    private TextView[] mTabs;
    private FragmentManager manager;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_my_publish;
    }

    @Override
    protected void processLogic() {
        initFragment();
    }

    @Override
    protected void setListener() {
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            switch (v.getId()) {
                case R.id.fl_my_publish:
                    Toast.makeText(MyPublishActivity.this, " clicked ", Toast.LENGTH_LONG).show();
                case R.id.mypub_tab_0:
                    switchFragment(R.id.mypub_tab_0);
                    break;
                case R.id.mypub_tab_1:
                    switchFragment(R.id.mypub_tab_1);
                    break;
                case R.id.mypub_tab_2:
                    switchFragment(R.id.mypub_tab_2);
                    break;
                case R.id.mypub_tab_3:
                    switchFragment(R.id.mypub_tab_3);
                    break;
                case R.id.my_back:
                    Intent intent = new Intent(MyPublishActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
            }
            }
        });
    }



    private void initFragment() {
        manager = getSupportFragmentManager();
        mTabs = new TextView[4];
        mTabs[0] = binding.mypubTab0;
        mTabs[1] = binding.mypubTab1;
        mTabs[2] = binding.mypubTab2;
        mTabs[3] = binding.mypubTab3;
        fragment1 = FragmentMyPublish.newFragment(1);
        fragment2 = FragmentMyPublish.newFragment(2);
        fragment3 = FragmentMyPublish.newFragment(3);
        fragment4 = FragmentMyPublish.newFragment(4);
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);
        switchFragment(R.id.mypub_tab_0);
    }

    public void switchFragment(int id) {
        FragmentTransaction ft = manager.beginTransaction();
        //fragment切换带动画
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        TextView textView =  findViewById(id);
        String tag = (String) textView.getTag();
        Fragment f = manager.findFragmentByTag(tag);
        if (f == null) {
            int num = Integer.parseInt(tag);
            ft.add(R.id.fl_my_publish, fragmentList.get(num), tag);

        }
        for (int i = 0; i < fragmentList.size(); i++) {
            Fragment fragment = fragmentList.get(i);
            if (fragment.getTag() != null) {
                if (fragment.getTag().equals(tag)) {
                    ft.show(fragment);
                    mTabs[i].setEnabled(false);
                } else {
                    ft.hide(fragment);
                    mTabs[i].setEnabled(true);
                }
            }
        }
        ft.commitAllowingStateLoss();
    }
}
