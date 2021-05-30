package com.example.app_btl.service;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_btl.Model.Book;
import com.example.app_btl.R;
import com.example.app_btl.service.model.Item;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    ImageView item_img;
    TextView textViewName, textViewAuthor, textViewDes, textViewPublisher,textViewRating;
    List<Item> list = new ArrayList<>();
    Context context;
    public void setItems(List<Item> list) {
        list = list;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View Contact = inflater.inflate(R.layout.item_card,parent,false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(Contact);
        return itemViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = list.get(position);

        Glide.with(context)
                .load(item.getVolumeInfo().getImageLinks().getThumbnail())
                .into(item_img);
        holder.textViewName.setText(item.getVolumeInfo().getTitle());
        holder.textViewAuthor.setText((CharSequence) item.getVolumeInfo().getAuthors());
        holder.textViewDes.setText(item.getVolumeInfo().getDescription());
        holder.textViewPublisher.setText(item.getVolumeInfo().getPublisher());
        holder.textViewRating.setText(item.getVolumeInfo().getRatingsCount() +"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
