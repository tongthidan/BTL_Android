package com.example.app_btl.service;

import com.example.app_btl.service.model.Welcome;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ImageService {
    static final String imageUrl  = "https://google-books.p.rapidapi.com/";
//    static final String clientId = "fuOu4odHIMZNCseveRF1qVtYgBE19N5Yt9ET01QehZk";
    static ImageService createService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //gưi nhan du lieu
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        //call API
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl(imageUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(ImageService.class);
    }
    @Headers({"x-rapidapi-key: 212b1f194cmshb46d6c131c1f024p178bc1jsn8738daa5e1fb",
                "x-rapidapi-host: google-books.p.rapidapi.com",
                "useQueryString: true"})
    @GET("volumes")
    Observable<Welcome> getRandomImages();
}
