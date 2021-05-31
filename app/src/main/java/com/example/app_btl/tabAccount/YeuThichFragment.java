package com.example.app_btl.tabAccount;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.app_btl.R;


public class YeuThichFragment extends Fragment {

    ImageView img1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v3 =  inflater.inflate(R.layout.fragment_yeu_thich, container, false);
        img1 = v3.findViewById(R.id.img1);
        return v3;
    }
}