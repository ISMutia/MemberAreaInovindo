package com.example.memberareainovindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class InfoPaketActivity extends AppCompatActivity {

    LinearLayout silver, gold, platinum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_paket);
        silver = (LinearLayout) findViewById(R.id.linearSilver);
        gold = (LinearLayout) findViewById(R.id.linearGold);
        platinum = (LinearLayout) findViewById(R.id.linearPlatinum);
        paket1();
        paket2();
        paket3();

    }

    private void paket1() {
        silver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSilver = new Intent(InfoPaketActivity.this,PaketSilver.class);
                startActivity(intSilver);
            }
        });
    }

    private void paket2() {
        gold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intGold = new Intent(InfoPaketActivity.this,PaketGold.class);
                startActivity(intGold);
            }
        });
    }

    private void paket3() {
        platinum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intPlatinum = new Intent(InfoPaketActivity.this,PaketPlatinum.class);
                startActivity(intPlatinum);
            }
        });
    }
}