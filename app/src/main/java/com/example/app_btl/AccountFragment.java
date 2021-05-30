package com.example.app_btl;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AccountFragment extends Fragment {
    TextView email, dangfollow, follower, like;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View acc =  inflater.inflate(R.layout.fragment_account, container, false);
        email = acc.findViewById(R.id.email);
        dangfollow = acc.findViewById(R.id.soFollow);
        follower = acc.findViewById(R.id.Follower);
        like = acc.findViewById(R.id.like);
        return acc;
    }
}