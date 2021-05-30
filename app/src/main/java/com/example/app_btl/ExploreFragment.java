package com.example.app_btl;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.app_btl.Model.Book;
import com.example.app_btl.service.ImageService;
import com.example.app_btl.service.RecycleViewItemAdapter;
import com.example.app_btl.service.model.Item;
import com.example.app_btl.service.model.Welcome;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class ExploreFragment extends Fragment {

    RecyclerView recyclerViewItem;
    RecycleViewItemAdapter adapter;
    SearchView searchView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_explore, container, false);




        recyclerViewItem = view.findViewById(R.id.recycleViewItem);
        searchView = view.findViewById(R.id.search);
        callService();

        return view;
    }

    private void callService() {
        Observable<Welcome> cryptoObservable = ImageService.createService().getRandomImages();

        cryptoObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }

    private void handleError(Throwable throwable) {
        Log.d("AppLog",throwable.toString());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void handleResults(Welcome welcomes) {
        welcomes.getItems().forEach(item ->

        {
            Log.d("AppLog", String.valueOf(item.getVolumeInfo().getImageLinks().getThumbnail()));
        });
        List<Item> list = welcomes.getItems();



        adapter = new RecycleViewItemAdapter();
        adapter.setItems(list);
        recyclerViewItem.setAdapter(adapter);
        recyclerViewItem.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}