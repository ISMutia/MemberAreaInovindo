package com.example.memberareainovindo.ui.riwayatorder;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.Adapter.RiwayatOrderAdapter;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.order.OrderResponse;
import com.example.memberareainovindo.Model.response.riwayatorder.DataItem;
import com.example.memberareainovindo.databinding.ActivityRiwayatOrderBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatOrderActivity extends AppCompatActivity {
    private ActivityRiwayatOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRiwayatOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
//        initOnClick();

    }

    private void initView() {
        loadDataOrder();
    }

//    private void initOnClick() {
//    }

    private void loadDataOrder() {
        RetroServer.getInstance().riwayatList().enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                if (response.body().getData()!=null){
                    //initRiwayatOrder(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {

            }
        });

    }


    private void initRiwayatOrder(List<DataItem> data) {
        RiwayatOrderAdapter adapter  = new RiwayatOrderAdapter(data);
    }


}