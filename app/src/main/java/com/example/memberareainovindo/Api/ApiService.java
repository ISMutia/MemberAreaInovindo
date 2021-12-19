package com.example.memberareainovindo.Api;

import com.example.memberareainovindo.Model.body.LoginBody;
import com.example.memberareainovindo.Model.body.OrderAddBody;
import com.example.memberareainovindo.Model.body.ProfileBody;
import com.example.memberareainovindo.Model.body.RegisterBody;
import com.example.memberareainovindo.Model.body.TestimoniAddBody;
import com.example.memberareainovindo.Model.response.billDetail.BillDetailResponse;
import com.example.memberareainovindo.Model.response.login.LoginResponse;
import com.example.memberareainovindo.Model.response.order.OrderResponse;
import com.example.memberareainovindo.Model.response.orderAdd.OrderAddResponse;
import com.example.memberareainovindo.Model.response.orderForm.FormResponse;
import com.example.memberareainovindo.Model.response.payment.PaymentResponse;
import com.example.memberareainovindo.Model.response.profile.ProfileResponse;
import com.example.memberareainovindo.Model.response.progress.ProgressResponse;
import com.example.memberareainovindo.Model.response.register.RegisterResponse;
import com.example.memberareainovindo.Model.response.riwayatOrder.OrderRiwayatResponse;
import com.example.memberareainovindo.Model.response.testimoni.TestimoniResponse;
import com.example.memberareainovindo.Model.response.testimoniAdd.TestimoniAddResponse;
import com.example.memberareainovindo.Model.response.userProfile.ResponseProfile;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //   query?id=1
    @GET("query")
    Call<String> query(@Query("id") int id);

    //   query/1
    //   query/id
    @GET("path/{id}")
    Call<String> path(@Path("id") int id);

    /*
    {
      "id" : "1"
    }
     */
    @FormUrlEncoded
    @POST("post1")
    Call<String> post1(@Field("id") int id);

    /*
    {
      "id" : "1"
    }
     */
    @POST("post2")
    Call<String> post2(@Body int id);

    //http://member-area.test/api/
    //userLogin
    @POST("userLogin")
    Call<LoginResponse> login(@Body LoginBody body);

    @POST("userRegister")
    Call<RegisterResponse> register(@Body RegisterBody body);

    @GET("orderList/{id}")
    Call<OrderResponse> orderList(@Path("id") String id);

    @GET("orderRiwayat/{id}")
    Call<OrderRiwayatResponse> orderRiwayat(@Path("id") String id);

    @GET("billDetail/{id}")
    Call<BillDetailResponse> billDetail(@Path("id") int id);

    @GET("testimoniList")
    Call<TestimoniResponse> testimoniList();

    @GET("progressList/{id}")
    Call<ProgressResponse> progressList(@Path("id") String id);

    @GET("orderGetForm")
    Call<FormResponse> orderGetForm();

    @POST("testimoniAdd")
    Call<TestimoniAddResponse> testimoniAdd(@Body TestimoniAddBody body);

    @POST("orderAdd")
    Call<OrderAddResponse> orderAdd(@Body OrderAddBody body);

    @PUT("userUpdate/{id}")
    Call<ProfileResponse> userUpdate(@Body ProfileBody body, @Path("id") String id);

    @Multipart
    @POST("userUpdatePhoto/{id}")
    Call<ResponseProfile> userUpdatePhoto(@Part MultipartBody.Part gambar, @Path("id")String id);

    @Multipart
    @POST("uploadPayment/{id}")
    Call<PaymentResponse> uploadPayment(@Part MultipartBody.Part bukti, @Path("id")String id);
}
