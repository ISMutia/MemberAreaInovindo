package com.example.memberareainovindo.ui.testimoni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.body.TestimoniAddBody;
import com.example.memberareainovindo.Model.response.testimoniAdd.TestimoniAddResponse;
import com.example.memberareainovindo.databinding.ActivityAddTestimoniBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTestimoniActivity extends AppCompatActivity {

    private ActivityAddTestimoniBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTestimoniBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initOnClick();
    }

    private void initView() {
    }

    private void initOnClick() {
        binding.btnSubmitTestimoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSTestiAction();
            }
        });
    }

    private void btnSTestiAction() {
        String desc = binding.edtTestimoni.getText().toString();

        if (desc.length() == 0) {
            Toast.makeText(this, "Field can't empty", Toast.LENGTH_SHORT).show();
            return;
        }
        TestimoniAddBody body = new TestimoniAddBody();
        body.setDescription(desc);

        RetroServer.getInstance().testiAdd(body).enqueue(new Callback<TestimoniAddResponse>() {
            @Override
            public void onResponse(Call<TestimoniAddResponse> call, Response<TestimoniAddResponse> response) {
                Toast.makeText(AddTestimoniActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                Intent intTesti = new Intent(AddTestimoniActivity.this, ListTestimoniActivity.class);
                startActivity(intTesti);
            }

            @Override
            public void onFailure(Call<TestimoniAddResponse> call, Throwable t) {
                Toast.makeText(AddTestimoniActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}