//package com.example.app_btl;
//
//import android.content.Context;
//import android.content.pm.LauncherActivityInfo;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//public class RecycleAccountAdapter extends  RecyclerView.Adapter<AccountViewHolder>{
//    @NonNull
//    @Override
//    public AccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Context context = parent.getContext();
//        LayoutInflater inflater= LayoutInflater.from(context);
//        inflater.inflate(R.layout.fragment_account,)
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AccountViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//}
//class AccountViewHolder extends RecyclerView.ViewHolder{
//    CircleImageView imageView;
//    TextView email;
//    public AccountViewHolder(@NonNull View itemView) {
//        super(itemView);
//        imageView = itemView.findViewById(R.id.profile_image);
//        email = itemView.findViewById(R.id.email);
//
//    }
//}
