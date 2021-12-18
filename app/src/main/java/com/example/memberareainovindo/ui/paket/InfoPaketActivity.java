package com.example.memberareainovindo.ui.paket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.R;

public class InfoPaketActivity extends AppCompatActivity {

    private RelativeLayout silver, gold, platinum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_info_paket);
        silver = findViewById(R.id.relativeSilver);
        gold = findViewById(R.id.relativeGold);
        platinum = findViewById(R.id.relativePlatinum);
        paket1();
        paket2();
        paket3();

    }

    private void paket1() {
        silver.setOnClickListener(v -> {
            Intent intSilver = new Intent(InfoPaketActivity.this, PaketSilver.class);
            startActivity(intSilver);
        });
    }

    private void paket2() {
        gold.setOnClickListener(v -> {
            Intent intGold = new Intent(InfoPaketActivity.this, PaketGold.class);
            startActivity(intGold);
        });
    }

    private void paket3() {
        platinum.setOnClickListener(v -> {
            Intent intPlatinum = new Intent(InfoPaketActivity.this, PaketPlatinum.class);
            startActivity(intPlatinum);
        });
    }
}