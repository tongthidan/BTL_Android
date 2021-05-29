package com.example.app_btl;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_btl.Book.RecycleViewBookAdapter;
import com.example.app_btl.DB.SQLiteBook;
import com.example.app_btl.Model.Book;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class KhoSachFragment extends Fragment {
    RecyclerView recyclerView;
    RecycleViewBookAdapter adapter;
    SQLiteBook sqLiteBook;
    FloatingActionButton btnAdd;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    AppBarLayout optionMenu;
    SearchView searchView;

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.mSearch));
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                List<Book> list = sqLiteBook.searchByName(newText);
//                adapter.setBooks(list);
//                recyclerView.setAdapter(adapter);
//                return true;
//            }
//        });
//        super.onCreateOptionsMenu(menu, inflater);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View khoView = inflater.inflate(R.layout.fragment_kho_sach, container, false);
        btnAdd = khoView.findViewById(R.id.btAdd);
        searchView = khoView.findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<Book> list = sqLiteBook.searchByName(newText);
                adapter.setBooks(list);
                recyclerView.setAdapter(adapter);
                return true;
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), AddBookActivity.class));
            }
        });
        sqLiteBook = new SQLiteBook(getContext());
        List<Book> list = sqLiteBook.getAll();
        recyclerView = khoView.findViewById(R.id.recycleView);

        adapter = new RecycleViewBookAdapter();
        adapter.setBooks(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return khoView;

    }



    @Override
    public void onStart() {
        super.onStart();
        List<Book> list = sqLiteBook.getAll();

        adapter.setBooks(list);
        recyclerView.setAdapter(adapter);
    }
}

