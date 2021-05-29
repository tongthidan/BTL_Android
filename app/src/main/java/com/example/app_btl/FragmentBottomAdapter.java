package com.example.app_btl;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentBottomAdapter extends FragmentStatePagerAdapter {
    int numberPage = 4;
    public FragmentBottomAdapter(@NonNull FragmentManager fm, int numberPage)
    {
        super(fm, numberPage);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new KhoSachFragment();
            case 1: return new ExploreFragment();
            case 2: return new ThongTinThemFragment();
            case 3: return new QuanLyFragment();
            default:  return new KhoSachFragment();
        }
    }

    @Override
    public int getCount() {
        return numberPage;
    }
}

