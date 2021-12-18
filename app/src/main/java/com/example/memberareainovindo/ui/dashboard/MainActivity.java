package com.example.memberareainovindo.ui.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.NotificationActivity;
import com.example.memberareainovindo.ProfileActivity;
import com.example.memberareainovindo.R;
import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityMainBinding;
import com.example.memberareainovindo.ui.login.LoginActivity;
import com.example.memberareainovindo.ui.order.OrderActivity;
import com.example.memberareainovindo.ui.progress.ProgressActivity;
import com.example.memberareainovindo.ui.testimoni.ListTestimoniActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = findViewById(R.id.buttom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.menu1);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.notification:
                    Intent gotonotif = new Intent(MainActivity.this, NotificationActivity.class);
                    startActivity(gotonotif);
                    overridePendingTransition(0,0);
                    return true;
                case R.id.menu1:
                    return true;
                case R.id.profile:
                    Intent gotoprofile = new Intent(MainActivity.this, ProfileActivity.class);
                    startActivity(gotoprofile);
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });

        mSessionManager = new SessionManager(this);

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
                Intent gotoorders = new Intent(MainActivity.this, OrderActivity.class);
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
        binding.cConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickUrl("https://wa.me/6285348449110");
            }
        });

    }
    public void clickUrl(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


}