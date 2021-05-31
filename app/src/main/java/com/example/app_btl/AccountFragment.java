package com.example.app_btl;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_btl.tabAccount.HorizontalFlipTransformation;
import com.example.app_btl.tabAccount.TabLayoutAdapter;
import com.google.android.material.tabs.TabLayout;


public class AccountFragment extends Fragment {
    TextView email, dangfollow, follower, like;
    private TabLayout tab;
    private ViewPager viewPager;
    private TabLayoutAdapter adapter;
    FragmentManager fm;
    private FragmentActivity myContext;
    ImageView img1, img2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fm = myContext.getSupportFragmentManager();
        View acc =  inflater.inflate(R.layout.fragment_account, container, false);
        email = acc.findViewById(R.id.email);
        dangfollow = acc.findViewById(R.id.soFollow);
        follower = acc.findViewById(R.id.Follower);
        like = acc.findViewById(R.id.like);
        tab = acc.findViewById(R.id.tab);
        img1 = acc.findViewById(R.id.img1);
        img2 = acc.findViewById(R.id.img2);
        viewPager = acc.findViewById(R.id.viewPagerLayout);
        adapter = new TabLayoutAdapter(fm, TabLayoutAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new HorizontalFlipTransformation());
        tab.setupWithViewPager(viewPager);



        return acc;
    }
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }
}