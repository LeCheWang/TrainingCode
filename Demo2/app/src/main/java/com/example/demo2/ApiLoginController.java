package com.example.demo2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiLoginController {
    String DOMAIN= "https://api.keno66.com/api/accounts/";
    Gson gson =new GsonBuilder().setDateFormat("yyyy MM dd HH:mm:ss").create();

    ApiLoginController control = new Retrofit.Builder()
            .baseUrl(DOMAIN)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiLoginController.class);

    @POST("login")
    Call<ResponseLogin> login(@Body() Account account);

}
