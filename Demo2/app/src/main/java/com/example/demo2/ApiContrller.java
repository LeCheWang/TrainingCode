package com.example.demo2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiContrller {
    String DOMAIN= "https://mocki.io/v1/";
    Gson gson =new GsonBuilder().setDateFormat("yyyy MM dd HH:mm:ss").create();

    ApiContrller control = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiContrller.class);

    @GET("d4867d8b-b5d5-4a48-a4ab-79131b5809b8")
    Call<List<User>> getUsers();


}
