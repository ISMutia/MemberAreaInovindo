package com.example.memberareainovindo.ui.testimoni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.memberareainovindo.Adapter.TestimoniAdapter;
import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.response.testimoni.DataItem;
import com.example.memberareainovindo.Model.response.testimoni.TestimoniResponse;
import com.example.memberareainovindo.databinding.ActivityListTestimoniBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListTestimoniActivity extends AppCompatActivity {

    private ActivityListTestimoniBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListTestimoniBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initOnClick();
    }

    private void initView() {

    }

    private void initOnClick() {
        binding.fabTambahTesti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoaddtesti = new Intent(ListTestimoniActivity.this, AddTestimoniActivity.class);
                startActivity(gotoaddtesti);
            }
        });
    }

    private void loadDataTestimoni() {
        RetroServer.getInstance()
                .testimoniList()
                .enqueue(new Callback<TestimoniResponse>() {
                    @Override
                    public void onResponse(Call<TestimoniResponse> call, Response<TestimoniResponse> response) {
                        //Toast.makeText(ListTestimoniActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        if(response.body().getData()!=null){
                            intRvTesti(response.body().getData());
                        }

                    }

                    @Override
                    public void onFailure(Call<TestimoniResponse> call, Throwable t) {
                        Toast.makeText(ListTestimoniActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void intRvTesti(List<DataItem> data) {
        try {
            TestimoniAdapter adapter = new TestimoniAdapter(data);
            binding.rvlistTestimo.setAdapter(adapter);
            binding.rvlistTestimo.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            binding.rvlistTestimo.hasFixedSize();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        loadDataTestimoni();
    }
}