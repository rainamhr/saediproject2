package com.example.queen.saediproject.API.Client;



import com.example.queen.saediproject.API.Constant.Constant;
import com.example.queen.saediproject.API.Model.MainResponse;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sikshya on 11/9/17.
 */

public interface Client {

    @GET("posts")
    Observable<List<MainResponse>> getMainResponseList(@Query("filter[posts_per_page]") String filterPPP, @Query("filter[s]") String filters);

    class Factory {
        public static Client create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(Client.class);
        }
    }
}
