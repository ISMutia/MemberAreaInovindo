package com.example.memberareainovindo.ui.riwayatbill;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.memberareainovindo.Adapter.RiwayatBillAdapter;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.bills.BillResponse;
import com.example.memberareainovindo.Model.response.bills.DataItem;
import com.example.memberareainovindo.databinding.ActivityRiwayatBillBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RiwayatBillActivity extends AppCompatActivity {
    private ActivityRiwayatBillBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRiwayatBillBinding.inflate(getLayoutInflater());
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
        RetroServer.getInstance()
                .riwayatBills()
                .enqueue(new Callback<BillResponse>() {
                    @Override
                    public void onResponse(Call<BillResponse> call, Response<BillResponse> response) {
                        if (response.body().getData() != null) {
                        initRvBills(response.body().getData());
                        }
                    }

                    @Override
                    public void onFailure(Call<BillResponse> call, Throwable t) {

                    }
                });
    }

    private void initRvBills(List<DataItem> data) {
        RiwayatBillAdapter adapter = new RiwayatBillAdapter(data);
        binding.rvlistRiwayatBills.setAdapter(adapter);
        binding.rvlistRiwayatBills.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvlistRiwayatBills.hasFixedSize();

    }


}