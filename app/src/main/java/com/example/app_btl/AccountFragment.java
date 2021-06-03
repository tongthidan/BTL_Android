package com.example.app_btl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.app_btl.tabAccount.HorizontalFlipTransformation;
import com.example.app_btl.tabAccount.TabLayoutAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;


public class AccountFragment extends Fragment {
    private static final int RESULT_LOAD_IMG = 1234;
    TextView email, dangfollow, follower, like;
    private TabLayout tab;
    private ViewPager viewPager;
    private TabLayoutAdapter adapter;
    FragmentManager fm;
    private FragmentActivity myContext;
    ImageView img1, img2;
    Button btnLogout, btnUpdateProfile;
    CircleImageView imageView;
    TextView textViewEmail, textViewName;
    FirebaseStorage storage;
    StorageReference mountainImagesRef;
    FirebaseUser user;
// Truy cap den danh sach cay Firebase
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = FirebaseStorage.getInstance();//
        user =  FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fm = myContext.getSupportFragmentManager();
        View acc =  inflater.inflate(R.layout.fragment_account, container, false);
        email = acc.findViewById(R.id.account_email);
        btnUpdateProfile = acc.findViewById(R.id.btnSuahoso);
        textViewName = acc.findViewById(R.id.account_name);
        dangfollow = acc.findViewById(R.id.soFollow);
        follower = acc.findViewById(R.id.Follower);
        like = acc.findViewById(R.id.like);
        tab = acc.findViewById(R.id.tab);
        imageView = acc.findViewById(R.id.profile_image);
        textViewEmail = acc.findViewById(R.id.account_email);
        btnLogout = acc.findViewById(R.id.btnLogout);
        img1 = acc.findViewById(R.id.img1);
        img2 = acc.findViewById(R.id.img2);
        viewPager = acc.findViewById(R.id.viewPagerLayout);
        adapter = new TabLayoutAdapter(fm, TabLayoutAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new HorizontalFlipTransformation());
        tab.setupWithViewPager(viewPager);

        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();

                // Name, email address, and profile photo Url
                String name = profile.getDisplayName();
                String email = profile.getEmail();
                Uri photoUrl = profile.getPhotoUrl();
                if(photoUrl!=null) {
                    Glide.with(getContext())
                            .load(photoUrl)
                            .into(imageView);
                }else{
                    StorageReference storageRef = storage.getReference();
                    mountainImagesRef = storageRef.child("images/" +user.getUid()+ ".jpg");
                    mountainImagesRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Log.d("AppLog",uri.toString());
                            Glide.with(getContext())
                                    .load(uri)
                                    .into(imageView);
                        }

                    });
                }

                textViewEmail.setText(email);
                textViewName.setText(name);

            }
        }
        else{
            imageView.setImageResource(R.drawable.tay);
        }
        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(),GioiThieuActivity.class);
                startActivity(i);
            }
        });
        imageView.setOnClickListener(v -> {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
        });

        return acc;
    }
    private void uploadImage() {
        StorageReference storageRef = storage.getReference();
        mountainImagesRef = storageRef.child("images/" +user.getUid()+ ".jpg");
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        UploadTask uploadTask = mountainImagesRef.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            }
        });
    }
    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_LOAD_IMG) {
                Uri uri = data.getData();
                Log.d("DanLog",uri.toString());
                imageView.setImageURI(uri);
                uploadImage();
            }
        }
    }
}