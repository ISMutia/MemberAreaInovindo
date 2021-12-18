package com.example.memberareainovindo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.memberareainovindo.ui.dashboard.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        BottomNavigationView bottomNavigationView = findViewById(R.id.buttom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.notification);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.notification:
                        return true;
                    case R.id.menu1:
                        Intent gotohome = new Intent(NotificationActivity.this, MainActivity.class);
                        startActivity(gotohome);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        Intent gotoproofile = new Intent(NotificationActivity.this, ProfileActivity.class);
                        startActivity(gotoproofile);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}