package com.example.memberareainovindo.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.Api.RetroServer;
import com.example.memberareainovindo.ForgotPassword;
import com.example.memberareainovindo.Model.body.LoginBody;
import com.example.memberareainovindo.Model.response.login.LoginResponse;
import com.example.memberareainovindo.databinding.ActivityLoginBinding;
import com.example.memberareainovindo.ui.register.RegisterActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity_HTTP_";

    //ActivityLoginBinding
    //activity_login
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        initOnClick();
    }

    private void initView() {
        binding.mEmail.setText("adikmutia@gmail.com");
        binding.mPassword.setText("12345678");
    }

    private void initOnClick() {
        binding.lupaPassword.setOnClickListener(v -> {
            Intent int2 = new Intent(LoginActivity.this, ForgotPassword.class);
            startActivity(int2);
        });
        binding.signup.setOnClickListener(v -> {
            Intent int1 = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(int1);
        });
        binding.btnLogin.setOnClickListener(v -> {
            btnLoginAction();
        });
    }

    private void btnLoginAction() {
        String email = binding.mEmail.getText().toString();
        String pass = binding.mPassword.getText().toString();
        if (email.length() == 0) {
            Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.length() == 0) {
            Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        LoginBody body = new LoginBody();
        body.setEmail(email);
        body.setPassword(pass);

        RetroServer.getInstance()
                .login(body)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Toast.makeText(LoginActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}