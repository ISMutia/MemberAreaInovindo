package com.example.memberareainovindo.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityMainBinding;
import com.example.memberareainovindo.ui.login.LoginActivity;
import com.example.memberareainovindo.ui.order.ListOrderActivity;
import com.example.memberareainovindo.ui.progress.ProgressActivity;
import com.example.memberareainovindo.ui.testimoni.ListTestimoniActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSessionManager = new SessionManager(this);
        //Toast.makeText(this, mSessionManager.getFullname(), Toast.LENGTH_SHORT).show();

        initView();
        initOnClick();
    }

    private void initView() {
        binding.textFulllname.setText(mSessionManager.getFullname());
    }

    private void initOnClick() {
        binding.cProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoprogress = new Intent(MainActivity.this, ProgressActivity.class);
                startActivity(gotoprogress);
            }
        });

        binding.cTestimoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoTesti = new Intent(MainActivity.this, ListTestimoniActivity.class);
                startActivity(gotoTesti);
            }
        });

        binding.cOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoorders = new Intent(MainActivity.this, ListOrderActivity.class);
                startActivity(gotoorders);
            }
        });
        binding.textFulllname.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mSessionManager.logout();
                Intent gotologin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(gotologin);
                return false;
            }
        });
    }


}