package com.example.memberareainovindo.Api;

import com.example.memberareainovindo.Model.body.LoginBody;
import com.example.memberareainovindo.Model.body.RegisterBody;
import com.example.memberareainovindo.Model.response.login.LoginResponse;
import com.example.memberareainovindo.Model.response.order.OrderResponse;
import com.example.memberareainovindo.Model.response.register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    //http://member-area.test/api/
    //userLogin
    @POST("userLogin")
    Call<LoginResponse> login(@Body LoginBody body);

    @POST("userRegister")
    Call<RegisterResponse> register(@Body RegisterBody body);

    @GET("orderList")
    Call<OrderResponse> orderList();

}
