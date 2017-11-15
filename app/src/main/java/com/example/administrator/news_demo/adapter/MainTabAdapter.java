package com.example.administrator.news_demo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.news_demo.fragment.FirstPageFragment;

import java.util.List;

/**
 * Created by Administrator on 2017/11/9.
 */

public class MainTabAdapter extends FragmentPagerAdapter{

    private List<FirstPageFragment> mList_fragment;
    private String[] mList_title;

    public MainTabAdapter(FragmentManager fm, List<FirstPageFragment> list_fragment, String[] list_title) {
        super(fm);

        mList_fragment = list_fragment;
        mList_title = list_title;
    }

    @Override
    public Fragment getItem(int position) {
        return mList_fragment.get(position);
    }

    @Override
    public int getCount() {
        return mList_fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList_title[position];
    }
}
