package com.example.memberareainovindo.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServerProgress {

    private static final String base_url = "http://member-area.test/api/progressList";

    private static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiProgress getInstance(){
        return setInit().create(ApiProgress.class);
    }
}
