package com.example.memberareainovindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    TextView textRegister;
    TextView textLupaPassword;
    EditText email, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textRegister = (TextView) findViewById(R.id.signup);
        textLupaPassword = (TextView) findViewById(R.id.lupa_password);
        email = (EditText) findViewById(R.id.m_email);
        password = (EditText) findViewById(R.id.m_password);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        textLupaPassword();
        textRegister();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogin();
            }
        });

        cek_form(email);
        cek_form(password);
    }

    void btnLogin()
    {
        if (email.getText().length()<1)
        {
            email.setBackgroundResource(R.drawable.form_error);
        }
        if (password.getText().length()<1)
        {
            password.setBackgroundResource(R.drawable.form_error);
        }
        else
        {
            kirim_data();
        }

    }

    void kirim_data()
    {
        String url="http://192.168.1.23/api/checkLogin.php";
        StringRequest respon = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            protected Map<String, String>getParams(){
                Map<String, String> kirim_form = new HashMap<String, String>();
                kirim_form.put("email", email.getText().toString());
                kirim_form.put("password", password.getText().toString());
                return  kirim_form;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(respon);

    }

    void cek_form(EditText editText)
    {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count<1)
                {
                    editText.setBackgroundResource(R.drawable.form_error);
                }
                else
                    {
                        editText.setBackgroundResource(R.drawable.form);
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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