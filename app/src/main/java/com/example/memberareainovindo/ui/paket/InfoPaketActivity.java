package com.example.memberareainovindo.ui.paket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.R;

public class InfoPaketActivity extends AppCompatActivity {

    RelativeLayout silver, gold, platinum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_paket);
        silver = (RelativeLayout) findViewById(R.id.relativeSilver);
        gold = (RelativeLayout) findViewById(R.id.relativeGold);
        platinum = (RelativeLayout) findViewById(R.id.relativePlatinum);
        paket1();
        paket2();
        paket3();

    }

    private void paket1() {
        silver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSilver = new Intent(InfoPaketActivity.this, PaketSilver.class);
                startActivity(intSilver);
            }
        });
    }

    private void paket2() {
        gold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intGold = new Intent(InfoPaketActivity.this, PaketGold.class);
                startActivity(intGold);
            }
        });
    }

    private void paket3() {
        platinum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intPlatinum = new Intent(InfoPaketActivity.this, PaketPlatinum.class);
                startActivity(intPlatinum);
            }
        });
    }
}