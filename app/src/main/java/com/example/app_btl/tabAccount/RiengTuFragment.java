package com.example.app_btl.tabAccount;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.app_btl.R;


public class RiengTuFragment extends Fragment {

    ImageView img2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v2 =  inflater.inflate(R.layout.fragment_rieng_tu, container, false);
        img2 = v2.findViewById(R.id.img2);
        return v2;
    }
}