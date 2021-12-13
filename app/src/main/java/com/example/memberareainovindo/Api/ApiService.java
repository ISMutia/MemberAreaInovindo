package com.example.memberareainovindo.Api;

import com.example.memberareainovindo.Model.body.LoginBody;
import com.example.memberareainovindo.Model.body.OrderAddBody;
import com.example.memberareainovindo.Model.body.RegisterBody;
import com.example.memberareainovindo.Model.body.TestimoniAddBody;
import com.example.memberareainovindo.Model.response.bills.BillResponse;
import com.example.memberareainovindo.Model.response.login.LoginResponse;
import com.example.memberareainovindo.Model.response.order.OrderResponse;
import com.example.memberareainovindo.Model.response.orderAdd.OrderAddResponse;
import com.example.memberareainovindo.Model.response.orderForm.FormResponse;
import com.example.memberareainovindo.Model.response.progress.ProgressResponse;
import com.example.memberareainovindo.Model.response.register.RegisterResponse;
import com.example.memberareainovindo.Model.response.riwayatOrder.OrderRiwayatResponse;
import com.example.memberareainovindo.Model.response.testimoni.TestimoniResponse;
import com.example.memberareainovindo.Model.response.testimoniAdd.TestimoniAddResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    //http://member-area.test/api/
    //userLogin
    @POST("userLogin")
    Call<LoginResponse> login(@Body LoginBody body);

    @POST("userRegister")
    Call<RegisterResponse> register(@Body RegisterBody body);

    @GET("orderList/{id}")
    Call<OrderResponse> orderList(@Path("id") String id);

    @GET("orderRiwayat")
    Call<OrderRiwayatResponse> orderRiwayat();

    @GET("testimoniList")
    Call<TestimoniResponse> testimoniList();

    @GET("billList")
    Call<BillResponse> billList();

    @GET("billList")
    Call<BillResponse> riwayatBills();

    @GET("progressList")
    Call<ProgressResponse> progressList();

    @GET("orderGetForm")
    Call<FormResponse> orderGetForm();

    @POST("testimoniAdd")
    Call<TestimoniAddResponse> testiAdd(@Body TestimoniAddBody body);

    @POST("orderAdd")
    Call<OrderAddResponse> orderAdd(@Body OrderAddBody body);

}
