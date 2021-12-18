package com.example.memberareainovindo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityAddOrderBinding;
import com.example.memberareainovindo.databinding.ActivityProfileBinding;
import com.example.memberareainovindo.ui.dashboard.MainActivity;
import com.example.memberareainovindo.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;
    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSessionManager = new SessionManager(this);

        initOnClick();

        BottomNavigationView bottomNavigationView = findViewById(R.id.buttom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.notification:
                        Intent gotonotif = new Intent(ProfileActivity.this, NotificationActivity.class);
                        startActivity(gotonotif);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.menu1:
                        Intent gotohome = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(gotohome);
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });
    }

    private void initOnClick() {
        binding.btnOut.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mSessionManager.logout();
                Intent gotologin = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(gotologin);
                return false;
            }
        });
    }

}