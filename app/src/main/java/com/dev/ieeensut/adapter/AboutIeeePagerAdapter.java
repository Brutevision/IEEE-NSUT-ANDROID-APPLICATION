package com.dev.ieeensut.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dev.ieeensut.fragments.MttsFragment;
import com.dev.ieeensut.fragments.CompSocietyFragment;
import com.dev.ieeensut.fragments.IasChapterFragment;
import com.dev.ieeensut.fragments.IeeeFragment;
import com.dev.ieeensut.fragments.WomenFragment;

/**
 *
 */

public class AboutIeeePagerAdapter extends FragmentPagerAdapter {

    private String pageTitle[] = {"IEEE","MTTS","WIE", "CS", "IAS"};

    public AboutIeeePagerAdapter(FragmentManager fm) {
            super(fm);
        }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new IeeeFragment();
        } else if(position == 1) {
            return new MttsFragment();
        } else if(position == 2) {
            return new WomenFragment();
        } else if (position==3){
            return new CompSocietyFragment();
        } else {
            return new IasChapterFragment();
        }
    }

    @Override
    public int getCount() {
        return pageTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }
}
