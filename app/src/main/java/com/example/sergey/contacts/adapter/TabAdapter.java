package com.example.sergey.contacts.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sergey.contacts.fragment.ContactsFragment;
import com.example.sergey.contacts.fragment.FavoriteContactsFragment;

/**
 * Created by Sergey on 20.06.2016.
 */
public class TabAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs;

    public TabAdapter(FragmentManager fm, int i) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ContactsFragment();
            case 1:
                return new FavoriteContactsFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 0;
    }
}
