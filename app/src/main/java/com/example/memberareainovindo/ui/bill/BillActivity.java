package com.example.memberareainovindo.ui.bill;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.R;
import com.example.memberareainovindo.databinding.ActivityBillBinding;
import com.example.memberareainovindo.ui.order.RiwayatOrderActivity;

public class BillActivity extends AppCompatActivity {
    private ActivityBillBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBillBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initOnClick();
    }

    private void initOnClick() {
        binding.btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotopay = new Intent(BillActivity.this, PaymentActivity.class);
                startActivity(gotopay);
            }
        });

        binding.btnPayLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoriwayat = new Intent(BillActivity.this, RiwayatOrderActivity.class);
                startActivity(gotoriwayat);
            }
        });
    }
}