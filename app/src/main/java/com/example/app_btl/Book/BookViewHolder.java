package com.example.app_btl.Book;

import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_btl.R;

public class BookViewHolder extends RecyclerView.ViewHolder {
    TextView textViewTenSach, textViewLoaiSach, textViewMota, textViewGiaSach;
    ImageView anhSach;
    public BookViewHolder(@NonNull View v) {
        super(v);
        textViewGiaSach = v.findViewById(R.id.book_price);
        textViewTenSach =  v.findViewById(R.id.book_name);
        textViewLoaiSach =  v.findViewById(R.id.book_type);
        textViewMota =  v.findViewById(R.id.book_des);
        anhSach =  v.findViewById(R.id.book_img);
    }
}
