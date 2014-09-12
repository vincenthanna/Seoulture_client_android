package powerwaveinteractive.com.tabsswipe.adapter;

import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import powerwaveinteractive.com.seoulture.Views.SwipeImageViewFragment;

public class SwipeImageViewAdapter extends FragmentPagerAdapter {
    public ArrayList<Bitmap> bitmaps;

    public SwipeImageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        SwipeImageViewFragment fragment = new SwipeImageViewFragment();
        fragment.setImageBitmap(bitmaps.get(index));
        return fragment;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return bitmaps.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}