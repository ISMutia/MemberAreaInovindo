package com.example.memberareainovindo.ui.bill;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.memberareainovindo.R;
import com.example.memberareainovindo.databinding.ActivityOrderBinding;
import com.example.memberareainovindo.databinding.ActivityPaymentMethodBinding;

public class PaymentActivity extends AppCompatActivity {
    private ActivityPaymentMethodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentMethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}