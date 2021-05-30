package com.example.app_btl.service;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_btl.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView item_img;
    TextView textViewName, textViewAuthor, textViewDes, textViewPublisher,textViewRating;
    public ItemViewHolder(@NonNull View v) {
        super(v);
        item_img = v.findViewById(R.id.item_img);
        textViewName = v.findViewById(R.id.item_NameBook);
        textViewAuthor=v.findViewById(R.id.item_author);
        textViewDes = v.findViewById(R.id.item_des);
        textViewPublisher= v.findViewById(R.id.item_publisher);
        textViewRating= v.findViewById(R.id.item_rating);

    }
}
