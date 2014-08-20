package powerwaveinteractive.com.tabsswipe.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import powerwaveinteractive.com.seoulture.*;


public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    private String[] tabs = { "Dashboard", "게임 목록", "Hot Movies & TV Program" };

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new DashboardFragment();
            case 1:
                // Games fragment activity
                return new GamesFragment();
            case 2:
                // Movies fragment activity
                return new MoviesFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}