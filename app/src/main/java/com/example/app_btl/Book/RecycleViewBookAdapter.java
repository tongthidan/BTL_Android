package com.example.app_btl.Book;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_btl.AddBookActivity;
import com.example.app_btl.KhoSachFragment;
import com.example.app_btl.Model.Book;
import com.example.app_btl.R;
import com.example.app_btl.UpdateBookActivity;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;
import static com.google.android.material.internal.ContextUtils.getActivity;

public class RecycleViewBookAdapter extends RecyclerView.Adapter<BookViewHolder> {
    TextView textViewTenSach, textViewLoaiSach, textViewMota, textViewGiaSach;
    ImageView anhSach;

    List<Book> listBook = new ArrayList<>();

    public void setBooks(List<Book> mlistBook) {
        listBook = mlistBook;
    }


    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View contactView = inflater.inflate(R.layout.book_card,parent,false);
        BookViewHolder bookViewHolder = new BookViewHolder(contactView);
        return  bookViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
            Book b = listBook.get(position);


            Log.d("AppLog",b.getAnhSach()+"");
            holder.anhSach.setImageResource(b.getAnhSach());
            holder.textViewTenSach.setText(b.getTenSach());
            holder.textViewLoaiSach.setText(b.getLoaiSach());
            holder.textViewMota.setText(b.getMota());
            holder.textViewGiaSach.setText(b.getGiaSach() +"");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context,
                            UpdateBookActivity.class);
                    intent.putExtra("book",b);
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }
}
