package com.example.memberareainovindo.ui.notification;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.memberareainovindo.Adapter.NotificationAdapter;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.notification.DataItem;
import com.example.memberareainovindo.Model.response.notification.NotificationResponse;
import com.example.memberareainovindo.ProfileActivity;
import com.example.memberareainovindo.R;
import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityNotificationBinding;
import com.example.memberareainovindo.ui.dashboard.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {
    private ActivityNotificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();

        BottomNavigationView bottomNavigationView = findViewById(R.id.buttom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.notification);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.notification:
                    return true;
                case R.id.menu1:
                    Intent gotohome = new Intent(NotificationActivity.this, MainActivity.class);
                    startActivity(gotohome);
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.profile:
                    Intent gotoproofile = new Intent(NotificationActivity.this, ProfileActivity.class);
                    startActivity(gotoproofile);
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });
    }

    private void initView() {
        loadData();
    }

    private void loadData() {
        RetroServer.getInstance()
                .notificationList(new SessionManager(getApplicationContext()).getId())
                .enqueue(new Callback<NotificationResponse>() {
                    @Override
                    public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {
                        if (response.body().getStatus().equals("success")) {
                            initRv(response.body().getData());
                        }
                    }

                    @Override
                    public void onFailure(Call<NotificationResponse> call, Throwable t) {

                    }
                });
    }

    private void initRv(List<DataItem> data) {
        NotificationAdapter adapter = new NotificationAdapter(data);
        binding.rvlistRiwayat.setAdapter(adapter);
        binding.rvlistRiwayat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvlistRiwayat.hasFixedSize();
    }
}