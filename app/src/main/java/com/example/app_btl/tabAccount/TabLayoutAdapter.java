package com.example.app_btl.tabAccount;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabLayoutAdapter  extends FragmentStatePagerAdapter {
    private  int numberPage = 3;
    public TabLayoutAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return  new AlbumFragment();
            case 1: return new YeuThichFragment();
            case 2: return new RiengTuFragment();
            default: return  new AlbumFragment();

        }

    }

    @Override
    public int getCount() {
        return numberPage;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Album";
            case 1: return " Yêu Thích";
            case 2: return "Riêng Tư";
            default: return "Album";

        }
    }
}

