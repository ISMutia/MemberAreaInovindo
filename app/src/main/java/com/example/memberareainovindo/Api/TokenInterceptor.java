package com.example.memberareainovindo.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class TokenInterceptor {

    public TokenInterceptor() {
    }

    public OkHttpClient getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .readTimeout(90, TimeUnit.SECONDS)
                .writeTimeout(90, TimeUnit.SECONDS)
                .connectTimeout(90, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .cache(null)
                .build();
    }
}
