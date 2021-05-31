package com.example.app_btl.tabAccount;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.app_btl.R;


public class AlbumFragment extends Fragment {
    ImageView img1, img2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v1 =   inflater.inflate(R.layout.fragment_album, container, false);
        img1 = v1.findViewById(R.id.img1);
        img2 = v1.findViewById(R.id.img2);
        return v1;
    }
}