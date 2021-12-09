package com.example.memberareainovindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.memberareainovindo.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    TextView textLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        textLogin = (TextView)findViewById(R.id.signin);
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(int3);
            }
        });

    }
}