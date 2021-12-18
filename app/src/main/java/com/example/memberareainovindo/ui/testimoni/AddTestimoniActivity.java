package com.example.memberareainovindo.ui.testimoni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.body.TestimoniAddBody;
import com.example.memberareainovindo.Model.response.testimoniAdd.TestimoniAddResponse;
import com.example.memberareainovindo.data.SessionManager;
import com.example.memberareainovindo.databinding.ActivityAddTestimoniBinding;
import com.example.memberareainovindo.ui.login.LoginActivity;
import com.example.memberareainovindo.ui.register.RegisterActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTestimoniActivity extends AppCompatActivity {

    private ActivityAddTestimoniBinding binding;
    private SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTestimoniBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mSessionManager = new SessionManager(this);
        initView();
        initOnClick();
    }

    private void initView() {
    }

    private void initOnClick() {
        binding.btnSubmitTestimoni.setOnClickListener(v -> {
            btnSTestiAction();
        });
    }

    private void btnSTestiAction() {
        if (binding.edtTestimoni.getText().toString().length() == 0) {
            Toast.makeText(this, "This field can't empty!", Toast.LENGTH_SHORT).show();
        } else {
            sendData();
        }
    }

    private void sendData() {
        String id = mSessionManager.getId();

        TestimoniAddBody body = new TestimoniAddBody();
        body.setIdCustomers(id);
        body.setDescription(binding.edtTestimoni.getText().toString());

        RetroServer.getInstance()
                .testimoniAdd(body)
                .enqueue(new Callback<TestimoniAddResponse>() {
                    @Override
                    public void onResponse(Call<TestimoniAddResponse> call, Response<TestimoniAddResponse> response) {
                        if (response.body().getStatus().equals("success")){
//                            Toast.makeText(AddTestimoniActivity.this, "data sukses disimpan", Toast.LENGTH_SHORT).show();
                            Intent intRegister = new Intent(AddTestimoniActivity.this, ListTestimoniActivity.class);
                            startActivity(intRegister);
                        }
                    }

                    @Override
                    public void onFailure(Call<TestimoniAddResponse> call, Throwable t) {

                    }
                });
    }

}

