package com.example.memberareainovindo.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.Model.body.RegisterBody;
import com.example.memberareainovindo.Model.response.register.RegisterResponse;
import com.example.memberareainovindo.databinding.ActivityRegisterBinding;
import com.example.memberareainovindo.ui.login.LoginActivity;
import com.gzeinnumer.da.dialog.datePickerDialog.single.SingleDatePickerDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initOnClick();

    }

    private void initView() {

    }

    private void initOnClick() {
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegisterAction();
            }
        });
        binding.mBirt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    binding.mBirt1.clearFocus();
                    mBirt1Action();
                }
            }
        });
    }

    private void mBirt1Action() {
        new SingleDatePickerDialog(getSupportFragmentManager())
                .setTimeZone("GMT")
                .setTitle("Pilih tanggal")
                .setSelectedToday(true)
                .setTimeFormat("yyyy-MM-dd") //pastikan polanya sama
                .onOkPressedCallBack(new SingleDatePickerDialog.OnOkPressed() {
                    @Override
                    public void onOkPressed(String value) {
                        //Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
                        binding.mBirt1.setText(value);
                    }
                })
                .build()
                .show();
    }

    private void btnRegisterAction() {
        String fullname = binding.mName1.getText().toString();
        String date_birth = binding.mBirt1.getText().toString();
        String email = binding.mEmail1.getText().toString();
        String pass = binding.mPassword1.getText().toString();

        if (fullname.length() == 0) {
            Toast.makeText(this, "Fullname tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (date_birth.length() == 0) {
            Toast.makeText(this, "Datebirth tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (email.length() == 0) {
            Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.length() == 0) {
            Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        RegisterBody body = new RegisterBody();
        body.setFullname(fullname);
        body.setDateBirth(date_birth);
        body.setEmail(email);
        body.setPassword(pass);

        RetroServer.getInstance()
                .register(body)
                .enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        Toast.makeText(RegisterActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                        if (response.body().getStatus().equals("success")) {
                            Intent intRegister = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intRegister);
                        } else {
                            Toast.makeText(RegisterActivity.this, "Data salah", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }


}