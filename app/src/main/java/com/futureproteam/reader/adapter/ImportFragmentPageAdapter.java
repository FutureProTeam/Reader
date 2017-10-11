package com.futureproteam.reader.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.futureproteam.reader.base.BaseFragment;

import java.util.List;

/**
 * Created by ding-syi on 2017/10/11.
 */

public class ImportFragmentPageAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;
    public ImportFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public ImportFragmentPageAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return context.getResources().getStringArray(R.array.import_book_title)[position];
//    }
}
