package com.example.queen.saediproject.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.queen.saediproject.Fragment.startFragment;
import com.example.queen.saediproject.Fragment.welcomePageFragment;

/**
 * Created by queen on 11/18/17.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {
    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new startFragment();
        }else if (position == 1) {
            return new welcomePageFragment();
        }
            return new startFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
