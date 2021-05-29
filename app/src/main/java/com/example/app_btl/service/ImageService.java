package com.example.app_btl.service;

import com.example.app_btl.service.model.Welcome;

import java.util.List;
import java.util.Observable;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImageService {
    static final String imageUrl  = "https://api.unsplash.com/";
    static final String clientId = "fuOu4odHIMZNCseveRF1qVtYgBE19N5Yt9ET01QehZk";
    static ImageService createService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(imageUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ImageService.class);
    }

//    @GET("photos/")
//    default Observable<List<Welcome>> getRandomImages(@Query("page") int page, @Query("client_id") String clientId) {
//        return null;
//    }
}
