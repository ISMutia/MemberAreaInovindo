package com.example.memberareainovindo.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.orderAdd.DomainItem;
import com.example.memberareainovindo.Model.response.orderAdd.FormResponse;
import com.example.memberareainovindo.Model.response.orderAdd.PriceItem;
import com.example.memberareainovindo.databinding.ActivityAddOrderBinding;
import com.example.memberareainovindo.ui.paket.InfoPaketActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddOrderActivity extends AppCompatActivity {

    private ActivityAddOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initOnClick();


    }


    private void initView() {
        loadFormData();

    }

    private void initOnClick() {
        binding.txtInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoinfo = new Intent(AddOrderActivity.this, InfoPaketActivity.class);
                startActivity(gotoinfo);
            }
        });
    }

    private List<PriceItem> price=new ArrayList<>();

    private List<DomainItem> domain=new ArrayList<>();



    private void loadFormData() {
        RetroServer.getInstance()
                .orderGetForm()
                .enqueue(new Callback<FormResponse>() {
                    @Override
                    public void onResponse(Call<FormResponse> call, Response<FormResponse> response) {
                        //Toast.makeText(AddOrderActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        if (response.body().getStatus().equals("success")){
                            price = response.body().getPrice();
                            domain = response.body().getDomain();
                        }
                    }

                    @Override
                    public void onFailure(Call<FormResponse> call, Throwable t) {

                    }
                });
    }

}