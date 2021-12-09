package com.example.memberareainovindo.Api;

import com.example.memberareainovindo.Model.ResponseReadDataProgress;
import com.example.memberareainovindo.Model.body.LoginBody;
import com.example.memberareainovindo.Model.response.login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("index.php")
    Call<ResponseReadDataProgress> getProgress();

    //http://member-area.test/api/
    //userLogin
    @POST("userLogin")
    Call<LoginResponse> login(@Body LoginBody body);
}
