package com.example.memberareainovindo.Api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {

    private static final String base_url = "http://member-area.inovindoacademy.com/api/";

    private static Retrofit setInit(){
        OkHttpClient client = new TokenInterceptor().getClient();
        return new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }
}
