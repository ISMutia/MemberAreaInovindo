package com.example.memberareainovindo.ui.progress;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.memberareainovindo.Adapter.ProgressAdapter;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.progress.DataItem;
import com.example.memberareainovindo.Model.response.progress.ProgressResponse;
import com.example.memberareainovindo.databinding.ActivityProgressBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgressActivity extends AppCompatActivity {

    private ActivityProgressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProgressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }

    private void initView() {
        loadDataProgress();
    }

    private void loadDataProgress() {
        RetroServer.getInstance()
                .progressList()
                .enqueue(new Callback<ProgressResponse>() {
            @Override
            public void onResponse(Call<ProgressResponse> call, Response<ProgressResponse> response) {
                if(response.body().getData()!=null){
                    initRvrw(response.body().getData());

                }

            }

            @Override
            public void onFailure(Call<ProgressResponse> call, Throwable t) {

            }
        });

    }

    private void initRvrw(List<DataItem> data) {
        try {
            ProgressAdapter adapter = new ProgressAdapter(data);
            binding.rvlistRiwayat.setAdapter(adapter);
            binding.rvlistRiwayat.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            binding.rvlistRiwayat.hasFixedSize();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}