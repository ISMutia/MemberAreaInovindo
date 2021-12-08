package com.example.memberareainovindo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView ProgressC, BillsC, OrdersC, Consultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressC = (CardView) findViewById(R.id.cProgress);
        BillsC = (CardView) findViewById(R.id.cBills);
        OrdersC = (CardView) findViewById(R.id.cOrders);

        ProgressC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoprogress = new Intent(MainActivity.this, ProgressActivity.class);
                startActivity(gotoprogress);
            }
        });

        BillsC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotobills = new Intent(MainActivity.this, RiwayatBillActivity.class);
                startActivity(gotobills);
            }
        });

        OrdersC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoorders = new Intent(MainActivity.this, ListOrderActivity.class);
                startActivity(gotoorders);
            }
        });
    }
}