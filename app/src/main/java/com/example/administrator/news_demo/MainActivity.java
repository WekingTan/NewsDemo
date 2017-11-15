package com.example.administrator.news_demo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.news_demo.adapter.MainTabAdapter;
import com.example.administrator.news_demo.fragment.FirstPageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;  //顶部标题选项布局
    private ViewPager mViewPager;
    private FirstPageFragment mFragment;
    private String[] mList_title;  //存放标题
    private List<FirstPageFragment> mFirstPageFragments;  //存放Fragment集合
    private MainTabAdapter mAdapter_title;  //标题的适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initView();

    }

    private void initData() {
        mList_title = getResources().getStringArray(R.array.tab_title);
        mFirstPageFragments = new ArrayList<>();

        //通过标题个数来创建 fragment
        for (int i = 0; i < mList_title.length; i++) {
            FirstPageFragment first = new FirstPageFragment();
            mFirstPageFragments.add(first);
        }

    }

    //初始化布局
    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_title);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mAdapter_title = new MainTabAdapter(getSupportFragmentManager(), mFirstPageFragments, mList_title);

        mViewPager.setAdapter(mAdapter_title);

        //TabLayout 绑定 viewpager
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
