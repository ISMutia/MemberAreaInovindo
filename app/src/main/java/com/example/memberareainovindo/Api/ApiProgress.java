package com.example.memberareainovindo.Api;

import com.example.memberareainovindo.Model.ResponseReadDataProgress;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface ApiProgress {

    @FormUrlEncoded
    @GET("read.php")
    Call<ResponseReadDataProgress> getProgress();
}
