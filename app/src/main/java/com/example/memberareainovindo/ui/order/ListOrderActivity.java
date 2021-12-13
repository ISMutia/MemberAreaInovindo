package com.example.memberareainovindo.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.memberareainovindo.Adapter.ListOrderAdapter;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.order.DataItem;
import com.example.memberareainovindo.Model.response.order.OrderResponse;
import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityListOrderBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListOrderActivity extends AppCompatActivity {

    private ActivityListOrderBinding binding;
    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSessionManager = new SessionManager(this);

        initView();
        initOnClick();

//        recyclerView = findViewById(R.id.rvlistorder);
//        recyclerView.setHasFixedSize(false);
//
//        ListOrderAdapter adapter = new ListOrderAdapter(temp);
//        recyclerView.setAdapter(adapter);


    }

    private void initView() {
        loadDataOrder();
    }

    private void initOnClick() {
        binding.fabTambah.setOnClickListener(v -> {
            Intent gotoaddorder = new Intent(ListOrderActivity.this, AddOrderActivity.class);
            startActivity(gotoaddorder);
        });

    }

    private void loadDataOrder() {
        String id = mSessionManager.getId();

        RetroServer.getInstance()
                .orderList(id)
                .enqueue(new Callback<OrderResponse>() {
                    @Override
                    public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                        //Toast.makeText(ListOrderActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        Log.d("orderid",response.body().toString());
                        if (response.body().getData()!= null){
                            initRv(response.body().getData());
                        }
                    }

                    @Override
                    public void onFailure(Call<OrderResponse> call, Throwable t) {

                    }
                });
    }

    private void initRv(List<DataItem> data) {
        try {
            ListOrderAdapter adapter = new ListOrderAdapter(data);
            binding.rvlistorder.setAdapter(adapter);
            binding.rvlistorder.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            binding.rvlistorder.hasFixedSize();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}