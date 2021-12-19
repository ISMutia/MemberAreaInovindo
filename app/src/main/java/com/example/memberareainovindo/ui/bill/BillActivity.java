package com.example.memberareainovindo.ui.bill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.billDetail.BillDetailResponse;
import com.example.memberareainovindo.Model.response.billDetail.DataItem;
import com.example.memberareainovindo.R;
import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityBillBinding;
import com.example.memberareainovindo.ui.order.AddOrderActivity;
import com.example.memberareainovindo.ui.order.RiwayatOrderActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillActivity extends AppCompatActivity {
    private ActivityBillBinding binding;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBillBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initOnClick();
        initView();

    }

    private void initView() {

    }

    private void initOnClick() {
        binding.btnCheckOut.setOnClickListener(v -> {
            checkOut();
        });

        binding.btnPayLater.setOnClickListener(v -> {
            Intent gotoriwayat = new Intent(BillActivity.this, RiwayatOrderActivity.class);
            startActivity(gotoriwayat);
        });
    }

    public void checkOut() {
            Intent gotopay = new Intent(BillActivity.this, PaymentActivity.class);
            gotopay.putExtra("id",id);
            startActivity(gotopay);
        }


    private void loadDataById() {
        id = getIntent().getIntExtra("id", 0);

        RetroServer.getInstance()
                .billDetail(id)
                .enqueue(new Callback<BillDetailResponse>() {
            @Override
            public void onResponse(Call<BillDetailResponse> call, Response<BillDetailResponse> response) {
                //Toast.makeText(BillActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                if (response.body().getStatus().equals("success")) {
//                            Toast.makeText(AddOrderActivity.this, "data sukses disimpan", Toast.LENGTH_SHORT).show();
//                    Intent gotobill = new Intent(BillActivity.this, PaymentActivity.class);
//                    startActivity(gotobill);
//                    mSessionManager.setFullname(response.body().getData().getFullname());
                    binding.eduser.setText(response.body().getData().get(0).getFullname());
                    binding.edBill.setText(response.body().getData().get(0).getId()+"");
                    binding.edType.setText(response.body().getData().get(0).getPriceName());
                    binding.edPname.setText(response.body().getData().get(0).getProjectName());
                    binding.txtDname1.setText(response.body().getData().get(0).getNameDomain());
                    binding.txtPrice.setText(response.body().getData().get(0).getTotalBayar()+"");

                    if (response.body().getData().get(0).getBukti() == null){
                        binding.btnCheckOut.setVisibility(View.VISIBLE);
                    }else {
                        binding.btnCheckOut.setVisibility(View.INVISIBLE);
                    }

                }
            }

            @Override
            public void onFailure(Call<BillDetailResponse> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();

        loadDataById();
    }
}