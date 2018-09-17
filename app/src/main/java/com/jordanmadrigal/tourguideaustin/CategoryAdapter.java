package com.jordanmadrigal.tourguideaustin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Adapter for displaying multiple fragments in a recycle view
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private String tabTitle[] = new String[]{"Museums","Restaurants", "Outdoors", "Events", "Nightlife"};

    public CategoryAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new MuseumsFragment();
        }else if(position == 1){
            return new RestaurantFragment();
        }else if(position == 2){
            return new OutdoorFragment();
        }else if(position == 3){
            return new EventFragment();
        }else{
            return new NightLifeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
