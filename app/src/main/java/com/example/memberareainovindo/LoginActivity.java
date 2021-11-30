package com.example.memberareainovindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView textRegister;
    TextView textLupaPassword;
    EditText email, password;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textRegister = (TextView) findViewById(R.id.signup);
        textLupaPassword = (TextView) findViewById(R.id.lupa_password);
        email = (EditText) findViewById(R.id.m_email);
        password = (EditText) findViewById(R.id.m_password);
        button = (Button) findViewById(R.id.btnLogin);
        textLupaPassword();
        textRegister();

    }

    private void textRegister() {
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(int1);
            }
        });
    }

    private void textLupaPassword() {
        textLupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(LoginActivity.this,ForgotPassword.class);
                startActivity(int2);
            }
        });
    }

}