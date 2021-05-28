package com.example.app_btl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ThongTinThemFragment extends Fragment {

    Button btnMessage, btnCall, btnLink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View  moreinfo =  inflater.inflate(R.layout.fragment_thong_tin_them, container, false);
        btnMessage = moreinfo.findViewById(R.id.btnNhanTin);
        btnCall = moreinfo.findViewById(R.id.btnCall);
        btnLink = moreinfo.findViewById(R.id.btnLink);

        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://faceworks.vn/phan-mem-quan-ly-thu-vien"));
                startActivity(intent);
            }
        });
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:" + "0964048725"));
                intent.putExtra("sms_body", "Tôi cần giúp đỡ !");
                startActivity(intent);
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 0964048725"));
                startActivity(intent);
            }
        });
        return moreinfo;
    }
}