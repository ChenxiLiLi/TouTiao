package com.bytedance.toutiao.ui.search;

import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bytedance.toutiao.R;
import com.bytedance.toutiao.base.BaseActivity;
import com.bytedance.toutiao.base.NormalViewModel;
import com.bytedance.toutiao.databinding.ActivitySearchBinding;
import com.bytedance.toutiao.ui.search.adapter.SearchActivityAdapter;
import com.bytedance.toutiao.ui.search.fragment.FragmentSearchCity;
import com.bytedance.toutiao.ui.search.fragment.FragmentSearchFriend;
import com.bytedance.toutiao.ui.search.fragment.FragmentSearchHot;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends BaseActivity<NormalViewModel, ActivitySearchBinding> {
    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager viewPager;
    private SearchActivityAdapter searchActivityAdapter;
    private EditText inputText;
    private String[] strings  = new String[]{"热搜榜", "同城榜", "好友榜"};

    @Override
    protected int getContentViewId() {
        return R.layout.activity_search;
    }

    @Override
    protected void processLogic() {
        TabLayout mTabLayout = findViewById(R.id.tab_layout);
        // 添加 tab item
        mTabLayout.addTab(mTabLayout.newTab().setText("热搜"));
        mTabLayout.addTab(mTabLayout.newTab().setText("同城"));
        mTabLayout.addTab(mTabLayout.newTab().setText("好友"));

        FragmentSearchHot fragmentSearchHot = new FragmentSearchHot();
        FragmentSearchCity fragmentSearchCity = new FragmentSearchCity();
        FragmentSearchFriend fragmentSearchFrient = new FragmentSearchFriend();
        fragments.add(fragmentSearchHot);
        fragments.add(fragmentSearchCity);
        fragments.add(fragmentSearchFrient);

        viewPager = findViewById(R.id.view_pager);
        searchActivityAdapter = new SearchActivityAdapter(getSupportFragmentManager(), 0, fragments,strings);
        viewPager.setAdapter(searchActivityAdapter);
        mTabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
        viewPager.setId(fragments.get(1).hashCode());



        inputText = (EditText) findViewById(R.id.et_search);

    }

    @Override
    protected void setListener() {

    }

}
