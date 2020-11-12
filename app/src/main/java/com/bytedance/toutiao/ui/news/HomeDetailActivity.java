package com.bytedance.toutiao.ui.news;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.ui.news.home.HomeFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeDetailActivity extends BaseActivity {

    private List<Fragment> fragmentList = new ArrayList<>();
    private ViewPager viewPager;
    private HomeFragmentAdapter homeFragmentAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_home_detail;
    }

    @Override
    protected void processLogic() {

        HomeBaseFragment followFragment = new HomeBaseFragment("follow");
        HomeBaseFragment newsFragment = new HomeBaseFragment("news");
        HomeBaseFragment sameCityFragment = new HomeBaseFragment("sameCity");


        fragmentList.add(followFragment);
        fragmentList.add(newsFragment);
        fragmentList.add(sameCityFragment);

        viewPager = findViewById(R.id.home_detail_view_pager);
        homeFragmentAdapter = new HomeFragmentAdapter(getSupportFragmentManager(), 0, fragmentList);

        viewPager.setAdapter(homeFragmentAdapter);
        viewPager.setCurrentItem(1);

    }

    @Override
    protected void setListener() {

    }


}
