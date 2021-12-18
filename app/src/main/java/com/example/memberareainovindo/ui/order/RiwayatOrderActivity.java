package com.example.memberareainovindo.ui.order;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.memberareainovindo.Adapter.RiwayatOrderAdapter;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.riwayatOrder.DataItem;
import com.example.memberareainovindo.Model.response.riwayatOrder.OrderRiwayatResponse;
import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityRiwayatOrderBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatOrderActivity extends AppCompatActivity {
    private ActivityRiwayatOrderBinding binding;

    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRiwayatOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSessionManager = new SessionManager(this);


        initView();
//        initOnClick();

    }

    private void initView() {
        loadDataRiwayat();
    }

//    private void initOnClick() {
//    }

    private void loadDataRiwayat() {
        String id = mSessionManager.getId();
        RetroServer.getInstance()
                .orderRiwayat(id)
                .enqueue(new Callback<OrderRiwayatResponse>() {
                    @Override
                    public void onResponse(Call<OrderRiwayatResponse> call, Response<OrderRiwayatResponse> response) {
                        if (response.body().getData() != null) {
                        initRvRiwayat(response.body().getData());
                        }
                    }

                    @Override
                    public void onFailure(Call<OrderRiwayatResponse> call, Throwable t) {

                    }
                });
    }

    private void initRvRiwayat(List<DataItem> data) {
        try {
            RiwayatOrderAdapter adapter = new RiwayatOrderAdapter(data);
            binding.rvlistRiwayatOrder.setAdapter(adapter);
            binding.rvlistRiwayatOrder.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            binding.rvlistRiwayatOrder.hasFixedSize();
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}