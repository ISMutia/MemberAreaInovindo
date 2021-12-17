package com.example.memberareainovindo.ui.order;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.memberareainovindo.Adapter.OrderAdapter;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.order.DataItem;
import com.example.memberareainovindo.Model.response.order.OrderResponse;
import com.example.memberareainovindo.R;
import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityOrderBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {

    private ActivityOrderBinding binding;
    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSessionManager = new SessionManager(this);

        initView();
        initOnClick();
    }
    private void initView() {

    }

    private void initOnClick() {
        binding.fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goaddorder = new Intent(OrderActivity.this, AddOrderActivity.class);
                startActivity(goaddorder);
            }
        });
    }

    private void loadDataOrder() {
        String id = mSessionManager.getId();

        RetroServer.getInstance()
                .orderList(id)
                .enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                if (response.body().getData()!=null){
                    initRvOrder(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<OrderResponse> call, Throwable t) {

            }
        });
    }

    private void initRvOrder(List<DataItem> data) {
        try{
            OrderAdapter adapter = new OrderAdapter(data);
            binding.rvlistorder.setAdapter(adapter);
            binding.rvlistorder.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            binding.rvlistorder.hasFixedSize();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();

        if (item_id == R.id.listOrder){
            Intent gotoorder = new Intent(OrderActivity.this, OrderActivity.class);
            startActivity(gotoorder);
        }else if (item_id == R.id.riwayatOrder){
            Intent gotoriwayatorder = new Intent(OrderActivity.this, RiwayatOrderActivity.class);
            startActivity(gotoriwayatorder);
        }
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();

        loadDataOrder();
    }
}